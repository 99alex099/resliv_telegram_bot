package by.resliv.telegrambot.services.implementations;

import by.resliv.telegrambot.services.interfaces.BotService;
import by.resliv.telegrambot.services.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotServiceImpl implements BotService {

    private static final String MESSAGE_DESCRIPTION = "Введите название города,чтобы получить информацию о нём";

    private final CityService cityService;

    public BotServiceImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public String formMessageToUserByCityName(String cityName) {
        return cityService.findDescriptionByCityName(cityName);
    }

    @Override
    public String formDescriptionMessage() {
        return MESSAGE_DESCRIPTION;
    }
}
