package com.fr.allianz.model.jsonParser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fr.allianz.model.entities.AllianzEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileParser {

    private static final Logger logger = LoggerFactory.getLogger(FileParser.class.getName());

    //@Value("${data}")
    //private String data;

    private List<AllianzEntity> allianzEntities = new ArrayList<>();

    public  List<AllianzEntity> readFile() {
        ObjectMapper mapper = getObjectMapper();

        try {
            allianzEntities = mapper
                    .readValue(AllianzEntity.class.getResourceAsStream("/data.json"),
                            new TypeReference<>() {
                            });
        } catch (IOException e) {
            logger.error("error while loading Json file " ,e.getCause());
        }
        return allianzEntities;
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return mapper;
    }


}
