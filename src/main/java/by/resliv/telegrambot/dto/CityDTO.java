package by.resliv.telegrambot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long id;
    private String cityName;
    private String description;

    public CityDTO(String cityName, String description) {
        this.cityName = cityName;
        this.description = description;
    }
}
