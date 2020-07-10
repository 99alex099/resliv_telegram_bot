package by.resliv.telegrambot.services.exceptions;

import by.resliv.telegrambot.dto.ExceptionDTO;
import lombok.Getter;

public class CityGeneralException extends Exception {
    @Getter
    private ExceptionDTO exceptionDTO;

    public CityGeneralException(String errorText, String invalidData) {
        super(errorText);
        exceptionDTO = new ExceptionDTO(errorText, invalidData);
    }
}
