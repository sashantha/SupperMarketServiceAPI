package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{
	
	Branch findByCode(String code);
	
	Branch findByName(String name);
	
	Branch findBranchById(Integer id);
}
