package com.fr.allianz.model.jsonParser;

import com.fr.allianz.model.entities.AllianzEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FileParserTest {

    @InjectMocks
    private FileParser fileParser;


    @Test
    public void should_return_all_AllianzEntities_when_file_exist() {
        //When
        List<AllianzEntity> result = fileParser.readFile();
        //Then
        Assert.assertEquals(result.size(), 7);
        Assert.assertEquals(result.get(0).getId(), 1);
        Assert.assertEquals(result.get(0).getLabel(), "allianz");

    }
}
