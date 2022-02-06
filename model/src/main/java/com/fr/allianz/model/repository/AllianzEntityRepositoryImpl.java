package com.fr.allianz.model.repository;

import com.fr.allianz.model.entities.AllianzEntity;
import com.fr.allianz.model.jsonParser.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Component
public class AllianzEntityRepositoryImpl implements AllianzEntityRepository{


    @Autowired
    private FileParser fileParser ;
    private List<AllianzEntity> allianzEntities;

    @PostConstruct
    private void init() {
        allianzEntities = fileParser.readFile();
    }


    @Override
    public List<AllianzEntity> findAll() {
        return allianzEntities;
    }

    @Override
    public Optional<AllianzEntity> findById(Long id) {
        return allianzEntities.stream().filter(allianzEntity -> allianzEntity.getId() == id).findFirst();
    }

    @Override
    public AllianzEntity save(AllianzEntity entity) {
        AllianzEntity entityTosave =  findById(entity.getId()).orElse(null);
        if(entityTosave != null ){
            entityTosave.setLabel(entity.getLabel());
            entityTosave.setDate(entity.getDate());
        }else{
            AllianzEntity newEntityTosave = new AllianzEntity(entity.getId() ,entity.getLabel() ,entity.getDate());
            allianzEntities.add(newEntityTosave);
        }
        return entityTosave;
    }

    @Override
    public void delete(long id) {
        allianzEntities.removeIf(allianzEntity -> allianzEntity.getId() == id);
    }

}
