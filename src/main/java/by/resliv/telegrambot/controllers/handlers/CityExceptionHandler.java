package by.resliv.telegrambot.controllers.handlers;

import by.resliv.telegrambot.dto.ExceptionDTO;
import by.resliv.telegrambot.services.exceptions.CityGeneralException;
import by.resliv.telegrambot.services.exceptions.CityIdNotFoundedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CityExceptionHandler {
    @ExceptionHandler(CityIdNotFoundedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionDTO cityNotFound(final CityGeneralException e) {
        return e.getExceptionDTO();
    }

    @ExceptionHandler(CityGeneralException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionDTO isException(final CityGeneralException e) {
        return e.getExceptionDTO();
    }
}
