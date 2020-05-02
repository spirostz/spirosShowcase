package com.spiros.view.transformer;

import com.spiros.common.model.City;
import com.spiros.view.model.CityVo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ActiveProfiles("test")
class CityVoTransformerTest {

    @Autowired
    private CityVoTransformer cityVoTransformer;

    @Test
    void fromVisualToTransfer() {
        final CityVo cityVo = new CityVo();
        cityVo.setId(3L);
        cityVo.setName("testName");

        final City city = cityVoTransformer.fromVisualToTransfer(cityVo).get();

        assertEquals(3L, city.getId());
        assertEquals("testName", city.getName());
        assertNull(city.getCreateDateTime());
        assertNull(city.getUpdateDateTime());

        assertFalse(cityVoTransformer.fromVisualToTransfer(null).isPresent());
    }

    @Test
    void fromTransferToVisual() {

        final City city = new City();
        city.setId(3L);
        city.setName("testName");

        final CityVo cityVo = cityVoTransformer.fromTransferToVisual(city).get();

        assertEquals(3L, cityVo.getId());
        assertEquals("testName", cityVo.getName());

        assertFalse(cityVoTransformer.fromTransferToVisual(null).isPresent());
    }
}