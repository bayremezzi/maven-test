package com.fr.allianz.model.repository;

import com.fr.allianz.model.entities.AllianzEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AllianzEntityRepositoryImplTest {

    @InjectMocks
    private AllianzEntityRepositoryImpl allianzEntityRepository;

    @Mock
    private AllianzEntity allianzEntity;

    @Mock
    private List<AllianzEntity> allianzEntities;

    @Test
    public void should_return_all_AllianzEntities() {
        //When
        List<AllianzEntity> result = allianzEntityRepository.findAll();
        //Then
        Assert.assertNotNull(result);

    }

    @Test
    public void should_add_allianz_entity_when_allianz_entity_id_is_null() {
        //When
        allianzEntityRepository.save(allianzEntity);
        //Then
        verify(allianzEntities, times(1)).add(any(AllianzEntity.class));

    }

    @Test
    public void should_update_allianz_entity_when_allianz_entity_id_is_not_null() {
        //Given
        List<AllianzEntity> allianzEntities1 = new ArrayList<>();
        AllianzEntity allianzEntity = new AllianzEntity(1L, "allianz", Date.from(Instant.now()));
        allianzEntities1.add(allianzEntity);
        //When
        Mockito.when(allianzEntities.stream()).thenReturn(allianzEntities1.stream());
        AllianzEntity result = allianzEntityRepository.save(allianzEntity);
        //Then
        Assert.assertEquals(result.getId(), allianzEntity.getId());
        Assert.assertEquals(result.getLabel(), allianzEntity.getLabel());
        Assert.assertEquals(result.getDate(), allianzEntity.getDate());

    }

    @Test
    public void should_delete_allianz_entity_when_allianz_entity_id() {
        //Given
        Long id = 7L;
        //When
        allianzEntityRepository.delete(id);
        //Then
        verify(allianzEntities, times(1)).removeIf(Mockito.<Predicate<AllianzEntity>>any());
        Assert.assertEquals(allianzEntities.get(7), null);


    }
}
