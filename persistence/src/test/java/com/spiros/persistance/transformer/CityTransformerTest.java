package com.spiros.persistance.transformer;

import com.spiros.common.model.City;
import com.spiros.persistance.entity.CityEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class CityTransformerTest {

    @Autowired
    private CityTransformer cityTransformer;

    @Test
    void fromEntityToTransfer() {
        final CityEntity cityEntity = new CityEntity();
        cityEntity.setId(3L);
        cityEntity.setCreateDateTime(LocalDateTime.MIN);
        cityEntity.setUpdateDateTime(LocalDateTime.MAX);
        cityEntity.setName("testName");

        final City city = cityTransformer.fromEntityToTransfer(cityEntity);

        assertEquals(3L, city.getId());
        assertEquals(LocalDateTime.MIN, city.getCreateDateTime());
        assertEquals(LocalDateTime.MAX, city.getUpdateDateTime());
        assertEquals("testName", city.getName());

    }

    @Test
    void fromTransferToEntity() {
        final City city = new City();
        city.setId(3L);
        city.setCreateDateTime(LocalDateTime.MIN);
        city.setUpdateDateTime(LocalDateTime.MAX);
        city.setName("testName");

        final CityEntity cityEntity = cityTransformer.fromTransferToEntity(city);

        assertEquals(3L, cityEntity.getId());
        assertEquals(LocalDateTime.MIN, cityEntity.getCreateDateTime());
        assertEquals(LocalDateTime.MAX, cityEntity.getUpdateDateTime());
        assertEquals("testName", cityEntity.getName());

    }
}