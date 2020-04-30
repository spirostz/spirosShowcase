package com.spiros.persistance.repository;

import com.spiros.persistance.entity.CityEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class CityRepoTest {

    @Autowired
    private CityRepo cityRepo;

    @Test
    public void testSave() {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName("testCityName");
        cityRepo.save(cityEntity);
    }
}