package by.resliv.telegrambot.services.interfaces;

import by.resliv.telegrambot.dto.CityDTO;
import by.resliv.telegrambot.services.exceptions.CityAlreadyExistsException;
import by.resliv.telegrambot.services.exceptions.CityDescriptionIsIncorrect;
import by.resliv.telegrambot.services.exceptions.CityIdNotFoundedException;
import by.resliv.telegrambot.services.exceptions.CityNameIsIncorrect;

import java.util.List;

public interface CityService {
    CityDTO findById(Long id) throws CityIdNotFoundedException;
    CityDTO update(Long cityId, CityDTO cityDTO) throws CityDescriptionIsIncorrect, CityNameIsIncorrect, CityAlreadyExistsException, CityIdNotFoundedException;
    CityDTO add(CityDTO cityDTO) throws CityAlreadyExistsException, CityDescriptionIsIncorrect, CityNameIsIncorrect;
    void deleteById(Long id) throws CityIdNotFoundedException;
    List<CityDTO> findAll();
    String findDescriptionByCityName(String cityName);
}
