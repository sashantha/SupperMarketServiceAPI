package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer>{

}
