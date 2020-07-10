package by.resliv.telegrambot.services.exceptions;

public class CityNameIsIncorrect extends CityGeneralException {
    public CityNameIsIncorrect(String cityName) {
        super("city name " + cityName + " is incorrect", cityName);
    }
    public CityNameIsIncorrect(String cityName, String description) {
        super("city name " + cityName + " is incorrect:" + description,
                cityName);
    }
}
