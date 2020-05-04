package com.spiros.core.service;

import com.spiros.common.model.City;
import com.spiros.persistance.repository.CityRepo;
import com.spiros.persistance.transformer.CityTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityTransformer cityTransformer;

    @Autowired
    private CityRepo cityRepo;

    public Optional<City> fetchById(final long id) {
        return cityTransformer.fromEntityToTransfer(
                cityRepo.findById(id).orElse(null));
    }

    public Optional<City> saveCity(final City city) {
        return cityTransformer.fromEntityToTransfer(cityRepo
                .save(Objects.requireNonNull(
                        cityTransformer.fromTransferToEntity(city).orElse(null))));
    }
}
