package by.resliv.telegrambot.services.exceptions;

public class CityAlreadyExistsException extends CityGeneralException {
    public CityAlreadyExistsException(String cityName) {
        super("city " + cityName + " already exists", cityName);
    }
}
