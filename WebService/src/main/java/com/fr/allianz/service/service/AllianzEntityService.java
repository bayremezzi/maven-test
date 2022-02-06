package com.fr.allianz.service.service;


import com.fr.allianz.model.entities.AllianzEntity;
import com.fr.allianz.service.dto.AllianzEntityDto;

import java.util.List;

public interface AllianzEntityService {
    /**
     * @param
     * @return
     */
    List<AllianzEntityDto> getEntities();

    /**
     * @param allianzEntity
     * @return
     */
    AllianzEntity addEntity(AllianzEntityDto allianzEntity);
    /**
     * @param allianzEntity
     * @return
     */
    AllianzEntity updateEntity(AllianzEntityDto allianzEntity);
    /**
     * @param keyId
     * @return
     */
    void deleteEntity(long keyId);
}
