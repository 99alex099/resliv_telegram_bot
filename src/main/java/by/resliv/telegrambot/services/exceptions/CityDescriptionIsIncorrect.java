package by.resliv.telegrambot.services.exceptions;

public class CityDescriptionIsIncorrect extends CityGeneralException {
    public CityDescriptionIsIncorrect(String cityDescription) {
        super("city description " + cityDescription + " is incorrect", cityDescription);
    }
    public CityDescriptionIsIncorrect(String cityDescription, String description) {
        super("city description " + cityDescription + " is incorrect:" + description,
                cityDescription);
    }
}
