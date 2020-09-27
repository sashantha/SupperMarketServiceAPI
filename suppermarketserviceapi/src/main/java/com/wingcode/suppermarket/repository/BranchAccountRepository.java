package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.BranchAccount;

@Repository
public interface BranchAccountRepository extends JpaRepository<BranchAccount, Integer>{
	
	@Query("select ba from BranchAccount ba join ba.branch b where b.id = ?1")
	List<BranchAccount> findByBranchId(Integer bId);
}
