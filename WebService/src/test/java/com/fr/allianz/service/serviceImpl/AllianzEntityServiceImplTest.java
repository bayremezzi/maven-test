package com.fr.allianz.service.serviceImpl;

import com.fr.allianz.model.entities.AllianzEntity;
import com.fr.allianz.model.repository.AllianzEntityRepositoryImpl;
import com.fr.allianz.service.dto.AllianzEntityDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AllianzEntityServiceImplTest {

    @InjectMocks
    private AllianzEntityServiceImpl allianzEntityService;

    @Mock
    private AllianzEntityRepositoryImpl allianzEntityRepository;

    @Test
    public void getEntities() {
        //When
        Mockito.when(allianzEntityRepository.findAll()).thenReturn(Arrays.asList(
                new AllianzEntity(1L, "allianz", Date.from(Instant.parse("2022, 02, 10"))),
                new AllianzEntity(3L, "oto", Date.from(Instant.parse(("2020, 02, 14"))))
                ));
        List<AllianzEntityDto> result = allianzEntityService.getEntities();
        //Then
        Assert.assertEquals(result.size(), 2);

    }

    @Test
    public void addEntity() {
        //Given
        AllianzEntityDto allianzEntityDto = new AllianzEntityDto(1L, "allianz", Date.from(Instant.parse("2022, 02, 10")));
        //When
        allianzEntityService.addEntity(allianzEntityDto);
        //Then
        verify(allianzEntityRepository, times(1)).save(any(AllianzEntity.class));
    }

    @Test
    public void updateEntity() {
        //Given
        AllianzEntityDto allianzEntityDto = new AllianzEntityDto(1L, "allianz", Date.from(Instant.parse("2022, 02, 10")));
        //When
        allianzEntityService.updateEntity(allianzEntityDto);
        //Then
        verify(allianzEntityRepository, times(1)).save(any(AllianzEntity.class));
    }

    @Test
    public void deleteEntity() {
        //When
        allianzEntityService.deleteEntity(1L);
        //Then
        verify(allianzEntityRepository, times(1)).delete(1L);
    }
}