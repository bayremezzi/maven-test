package com.fr.allianz.service.serviceImpl;

import com.fr.allianz.model.entities.AllianzEntity;
import com.fr.allianz.model.repository.AllianzEntityRepository;
import com.fr.allianz.service.dto.AllianzEntityDto;
import com.fr.allianz.service.mapper.EntityMapper;
import com.fr.allianz.service.service.AllianzEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllianzEntityServiceImpl implements AllianzEntityService {

    @Autowired
    private EntityMapper entityMapper ;
    @Autowired
    private AllianzEntityRepository allianzEntityRepository;

    public AllianzEntityServiceImpl(EntityMapper entityMapper) {
        this.entityMapper = entityMapper;
    }

    @Override
    public List<AllianzEntityDto> getEntities() {
        return (List<AllianzEntityDto>) entityMapper.toEntity(allianzEntityRepository.findAll());
    }

    @Override
    public AllianzEntity addEntity(AllianzEntityDto allianzEntityDto) {
        AllianzEntity entity = (AllianzEntity) entityMapper.toEntity(allianzEntityDto);
        return allianzEntityRepository.save(entity);
    }

    @Override
    public AllianzEntity updateEntity(AllianzEntityDto allianzEntityDto) {
        AllianzEntity entity = (AllianzEntity) entityMapper.toEntity(allianzEntityDto);
        return allianzEntityRepository.save(entity);
    }

    @Override
    public void deleteEntity(long keyId) {
        allianzEntityRepository.delete(keyId);
    }
}
