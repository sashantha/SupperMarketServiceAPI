package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer>{
	
	List<Unit> findByUnitType(String unitType);
	
	Unit findByUnitName(String unitName);
}
