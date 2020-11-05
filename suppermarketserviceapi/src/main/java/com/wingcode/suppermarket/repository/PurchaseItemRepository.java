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

	@Query("select pi from PurchaseItem pi join pi.purchase p join p.branch b where b.id = ?1 and pi.purchaseDate = ?2 and pi.recordState = 'fine'")	
	List<PurchaseItem> findByPurchaseDate(Integer bid, Date purchaseDate);
	
	@Query("select pi from PurchaseItem pi join pi.purchase p join p.branch b where b.id = ?1 and p.id = ?2 and pi.recordState = 'fine'")
	List<PurchaseItem> findByPurchaseId(Integer bid, Long purchaseId);

	@Query("select pi from PurchaseItem pi join pi.item i join pi.purchase ph join ph.branch b where b.id = :bid and i.id = :itemId and pi.recordState = 'fine'")
	List<PurchaseItem> findByItemId(@Param("bid") Integer bid, @Param("itemId") Long itemId);
	
	@Query("select p from PurchaseItem p join p.purchase ph join ph.branch b where b.id = :bid and p.expireDate between :start and :end and p.recordState = 'fine'")
	List<PurchaseItem> findByExpireDate(@Param("bid") Integer bid, @Param("start")Date start, @Param("end")Date end);
}
