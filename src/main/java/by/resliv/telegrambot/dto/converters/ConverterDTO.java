package by.resliv.telegrambot.dto.converters;

import java.util.List;

public interface ConverterDTO<Entity, DTO> {
    DTO convertToDTO(Entity entity);
    Entity convertToEntity(DTO dto);
    List<DTO> convertToDTO(List<Entity> entityList);
}
