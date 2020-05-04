package com.spiros.core.service;

import com.spiros.common.model.City;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
class CityServiceTest {

    @Autowired
    private CityService cityService;

    private City savedCity;

    @BeforeAll
    public void saveACity() {
        savedCity = new City();
        savedCity.setName("Athens");
        savedCity = cityService.saveCity(savedCity).get();
    }

    @Test
    void fetchById() {
        final City fetchedCity = cityService.fetchById(savedCity.getId()).get();
        assertNotNull(fetchedCity.getId());
        assertNotNull(fetchedCity.getCreateDateTime());
        assertNotNull(fetchedCity.getUpdateDateTime());
        assertEquals("Athens", fetchedCity.getName());

    }

    @Test
    void saveCity() {
        assertNotNull(savedCity.getId());
        assertNotNull(savedCity.getCreateDateTime());
        assertNotNull(savedCity.getUpdateDateTime());
        assertEquals("Athens", savedCity.getName());
    }


}