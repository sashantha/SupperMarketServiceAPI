package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

	@Query("select i from SaleItem i join i.saleInvoice s join s.branch b where b.id = ?1 and i.saleDate = ?2 and i.recordState = 'fine'")
	List<SaleItem> findBySaleDate(Integer bid, Date saleDate);

	@Query("select i from SaleItem i join i.saleInvoice s join s.branch b where b.id = ?1 and s.id = ?2 and i.recordState = 'fine'")
	List<SaleItem> findByInvoiceId(Integer bid, Long invoiceId);

	@Query("select i from SaleItem i join i.item t join i.saleInvoice s join s.branch b where b.id = ?1 and t.id = ?2 and i.recordState = 'fine'")
	List<SaleItem> findByItemId(Integer bid, Long itemId);
}
