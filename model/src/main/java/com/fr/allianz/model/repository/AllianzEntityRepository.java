package com.fr.allianz.model.repository;

import com.fr.allianz.model.entities.AllianzEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AllianzEntityRepository {

    List<AllianzEntity> findAll();
    Optional<AllianzEntity> findById(Long id);
    AllianzEntity save(AllianzEntity entity);
    void delete(long id);
}
