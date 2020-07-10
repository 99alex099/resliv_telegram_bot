package by.resliv.telegrambot.services.implementations;

import by.resliv.telegrambot.dto.CityDTO;
import by.resliv.telegrambot.dto.converters.ConverterDTO;
import by.resliv.telegrambot.entities.City;
import by.resliv.telegrambot.repository.CityRepository;
import by.resliv.telegrambot.services.exceptions.CityAlreadyExistsException;
import by.resliv.telegrambot.services.exceptions.CityDescriptionIsIncorrect;
import by.resliv.telegrambot.services.exceptions.CityIdNotFoundedException;
import by.resliv.telegrambot.services.exceptions.CityNameIsIncorrect;
import by.resliv.telegrambot.services.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private static final String MESSAGE_CITY_NOT_FOUNDED = "Информация о заданном городе отсутствует";

    private final CityRepository cityRepository;
    private final ConverterDTO<City, CityDTO> cityConverterDTO;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ConverterDTO<City, CityDTO> cityConverterDTO) {
        this.cityRepository = cityRepository;
        this.cityConverterDTO = cityConverterDTO;
    }

    @Override
    public CityDTO findById(Long id) throws CityIdNotFoundedException {
        return cityConverterDTO.convertToDTO(
                cityRepository.findById(id).orElseThrow(
                        () -> new CityIdNotFoundedException(id)
                )
        );
    }

    @Override
    public CityDTO update(Long cityId, CityDTO cityDTO) throws CityDescriptionIsIncorrect, CityNameIsIncorrect,
            CityAlreadyExistsException, CityIdNotFoundedException {

        cityDTOIsCorrect(cityDTO);

        cityDTO.setId(cityId);

        if (cityRepository.existsById(cityId)) {

            if (cityDTO.getCityName().equals(findById(cityId).getCityName()) ||
                    !cityRepository.existsByCityName(cityDTO.getCityName())) {

                City savedCity = cityRepository.save(
                        cityConverterDTO.convertToEntity(cityDTO)
                );

                return cityConverterDTO.convertToDTO(savedCity);
            } else {
                throw new CityAlreadyExistsException(cityDTO.getCityName());
            }
        } else {
            throw new CityIdNotFoundedException(cityId);
        }
    }

    @Override
    public CityDTO add(CityDTO cityDTO) throws CityAlreadyExistsException, CityDescriptionIsIncorrect, CityNameIsIncorrect {

        cityDTOIsCorrect(cityDTO);

        cityDTO.setId(null);

        if (!cityRepository.existsByCityName(cityDTO.getCityName())) {

            City addedCity = cityRepository.save(
                    cityConverterDTO.convertToEntity(cityDTO)
            );
            return cityConverterDTO.convertToDTO(addedCity);
        } else {
            throw new CityAlreadyExistsException(cityDTO.getCityName());
        }
    }

    private void cityDTOIsCorrect(CityDTO cityDTO) throws CityNameIsIncorrect, CityDescriptionIsIncorrect {
        if (cityDTO.getCityName() == null || cityDTO.getCityName().equals("")) {
            throw new CityNameIsIncorrect(cityDTO.getCityName(),
                    "it is empty");
        } else if ( cityDTO.getDescription() == null || cityDTO.getDescription().equals("") ) {
            throw new CityDescriptionIsIncorrect(cityDTO.getDescription(), "it is empty");
        } else if (cityDTO.getCityName().length() > 64) {
            throw new CityNameIsIncorrect(cityDTO.getCityName(), "size must not exceed 64");
        } else if (cityDTO.getDescription().length() > 256) {
            throw new CityNameIsIncorrect(cityDTO.getDescription(), "size must not exceed 256");
        }
    }

    @Override
    public void deleteById(Long id) throws CityIdNotFoundedException {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
        } else {
            throw new CityIdNotFoundedException(id);
        }
    }

    @Override
    public List<CityDTO> findAll() {
        return cityConverterDTO.convertToDTO(
                cityRepository.findAll()
        );
    }

    @Override
    public String findDescriptionByCityName(String cityName) {
        Optional<City> foundedCity = cityRepository.findByCityName(cityName);

        return foundedCity.isPresent() ?
                foundedCity.get().getDescription()
                : MESSAGE_CITY_NOT_FOUNDED;
    }
}
