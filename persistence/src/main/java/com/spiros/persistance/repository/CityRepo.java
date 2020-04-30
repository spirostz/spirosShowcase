package com.spiros.persistance.repository;

import com.spiros.persistance.entity.CityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<CityEntity, Long> {

}