package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.PurchaseItem;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {

	List<PurchaseItem> findByPurchaseDate(Date purchaseDate);
	
	@Query("select pi from PurchaseItem pi join pi.purchase p where p.id = ?1")
	List<PurchaseItem> findByPurchaseId(Long purchaseId);

	@Query("select pi from PurchaseItem pi join pi.item i where i.id = ?1")
	List<PurchaseItem> findByItemId(Long itemId);
	
	@Query("select p from PurchaseItem p where p.expireDate between :start and :end")
	List<PurchaseItem> findByExpireDate(@Param("start")Date start, @Param("end")Date end);
}
