package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Item;
import com.wingcode.suppermarket.model.ItemCriteria;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("select i from Item i where i.code = ?1")
	Item findByCode(String code);

	@Query("select i from Item i where i.barcode = ?1")
	Item findByBarcode(String barcode);

	@Query("select i from Item i where i.name = ?1")
	Item findByName(String name);

	@Query("select i from Item i join i.itemGroup g where g.groupName = ?1")
	List<Item> findByGroupName(String groupName);

	@Query("select i from Item i join i.itemSubGroup g where g.subGroupName = ?1")
	List<Item> findBySubGroupName(String subGroupName);

	@Query("select new com.wingcode.suppermarket.model.ItemCriteria(i.id, i.code, i.barcode, i.name, i.otherName) from Item i")
	List<ItemCriteria> findAllIdCodeBarcodeAndName();

}
