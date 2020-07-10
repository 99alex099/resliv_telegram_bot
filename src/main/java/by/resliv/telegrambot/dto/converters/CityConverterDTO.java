package by.resliv.telegrambot.dto.converters;

import by.resliv.telegrambot.dto.CityDTO;
import by.resliv.telegrambot.entities.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityConverterDTO implements ConverterDTO<City, CityDTO> {

    @Override
    public CityDTO convertToDTO(City city) {
        return new CityDTO(city.getId(),
                city.getCityName(),
                city.getDescription());
    }

    @Override
    public City convertToEntity(CityDTO cityDTO) {
        return new City(cityDTO.getId(),
                cityDTO.getCityName(),
                cityDTO.getDescription());
    }

    @Override
    public List<CityDTO> convertToDTO(List<City> cities) {
        return cities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
