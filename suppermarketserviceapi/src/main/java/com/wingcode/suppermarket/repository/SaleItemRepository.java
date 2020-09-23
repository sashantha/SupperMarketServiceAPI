package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

	List<SaleItem> findBySaleDate(Date saleDate);

	@Query("select i from SaleItem i join i.saleInvoice s where s.id = ?1")
	List<SaleItem> findByInvoiceId(Long invoiceId);

	@Query("select i from SaleItem i join i.item t where t.id = ?1")
	List<SaleItem> findByItemId(Long itemId);
}
