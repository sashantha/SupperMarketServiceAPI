package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.StoreInfor;

@Repository
public interface StoreInforRepository extends JpaRepository<StoreInfor, Long> {

	@Query("select s from StoreInfor s join s.item i join s.branch b where i.id = ?1 and b.id = ?2")
	StoreInfor findByItemIdAndBranchId(Long itemId, Integer branchId);
	
	@Query("select s from StoreInfor s join s.item i where i.id = ?1")
	List<StoreInfor> findByItemId(Long itemId);
}
