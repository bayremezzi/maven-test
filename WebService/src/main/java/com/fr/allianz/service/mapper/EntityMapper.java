package com.fr.allianz.service.mapper;

import java.util.List;
/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <AllianzEntity> - DTO type parameter.
 * @param <AllianzEntityDto> - Entity type parameter.
 */
public interface EntityMapper<AllianzEntity,AllianzEntityDto> {

    AllianzEntity toEntity(AllianzEntityDto dto);

    AllianzEntityDto toDto(AllianzEntity entity);

    List<AllianzEntityDto> toDtos(List<AllianzEntity> dtoList);

    List<AllianzEntity> toEntities(List<AllianzEntityDto> entityList);
}
