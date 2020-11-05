package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.UnitOfMeasurement;

@Repository
public interface UnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Integer>{
	
	UnitOfMeasurement findByUnitDescription(String unitDescription);
	
	List<UnitOfMeasurement> findByUnitType(String unitType);
	
}
