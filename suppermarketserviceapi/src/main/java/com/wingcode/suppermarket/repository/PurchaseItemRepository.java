package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.PurchaseItem;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
	
	@Query("select pi from PurchaseItem pi join pi.purchase p where p.purchaseId = ?1 and not p.recordState = 'deleted'")
	List<PurchaseItem> findByPurchaseId(Long purchaseId);
	
	@Query("select pi from PurchaseItem pi join pi.item i where i.itemCode = ?1")
	List<PurchaseItem> findByItemId(String itemCode);
	
	
}
