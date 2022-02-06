package com.fr.allianz.service.mapper;

import com.fr.allianz.model.entities.AllianzEntity;
import com.fr.allianz.service.dto.AllianzEntityDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityMapperImpl implements EntityMapper<AllianzEntity, AllianzEntityDto> {

    @Override
    public AllianzEntity toEntity(AllianzEntityDto allianzEntityDto) {
        if ( allianzEntityDto == null ) {
            return null;
        }
        return new AllianzEntity(allianzEntityDto.getId(),
                allianzEntityDto.getLabel(),
                allianzEntityDto.getDate());
    }

    @Override
    public AllianzEntityDto toDto(AllianzEntity entity) {
        if ( entity == null ) {
            return null;
        }
        return new AllianzEntityDto(entity.getId(),entity.getLabel() , entity.getDate());
    }

    @Override
    public List<AllianzEntityDto> toDtos(List<AllianzEntity> dtoList) {
        if ( dtoList == null ) {
            return null;
        }
        List<AllianzEntityDto> dtos = new ArrayList<>(dtoList.size());
        for ( AllianzEntity AllianzEntity : dtoList ) {
            dtos.add( toDto( AllianzEntity ) );
        }
        return dtos;
    }

    @Override
    public List<AllianzEntity> toEntities(List<AllianzEntityDto> entityList) {
        if ( entityList == null ) {
            return null;
        }
        List<AllianzEntity> entities = new ArrayList<>(entityList.size());
        for ( AllianzEntityDto allianzEntityDto : entityList ) {
            entities.add( toEntity( allianzEntityDto ) );
        }
        return entities;
    }

}
