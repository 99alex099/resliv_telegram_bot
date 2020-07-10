package by.resliv.telegrambot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionDTO {
    private String errorText;
    private String invalidData;
}
