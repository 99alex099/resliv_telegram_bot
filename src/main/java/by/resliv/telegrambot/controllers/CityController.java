package by.resliv.telegrambot.controllers;

import by.resliv.telegrambot.dto.CityDTO;
import by.resliv.telegrambot.services.exceptions.CityAlreadyExistsException;
import by.resliv.telegrambot.services.exceptions.CityDescriptionIsIncorrect;
import by.resliv.telegrambot.services.exceptions.CityIdNotFoundedException;
import by.resliv.telegrambot.services.exceptions.CityNameIsIncorrect;
import by.resliv.telegrambot.services.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<CityDTO> findCityList() {
        return cityService.findAll();
    }

    @GetMapping("{id}")
    public CityDTO findById(@PathVariable Long id) throws CityIdNotFoundedException {
        return cityService.findById(id);
    }

    @PostMapping
    public CityDTO addCity(@RequestBody CityDTO cityDTO) throws CityAlreadyExistsException, CityDescriptionIsIncorrect,
            CityNameIsIncorrect {
        return cityService.add(cityDTO);
    }

    @PutMapping("{id}")
    public CityDTO updateCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) throws CityDescriptionIsIncorrect,
            CityIdNotFoundedException, CityAlreadyExistsException, CityNameIsIncorrect {
        return cityService.update(id, cityDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCity(@PathVariable Long id) throws CityIdNotFoundedException {
        cityService.deleteById(id);
    }
}
