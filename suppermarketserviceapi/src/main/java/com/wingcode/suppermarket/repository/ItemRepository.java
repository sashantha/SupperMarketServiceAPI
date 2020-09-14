package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Item;
import com.wingcode.suppermarket.model.ItemCriteria;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("select i from Item i where i.itemCode = ?1 and not i.recordState = 'deleted'")
	Item findByItemCode(String itemCode);
	
	@Query("select i from Item i where i.itemBarcode = ?1 and not i.recordState = 'deleted'")
	Item findByItemBarcode(String itemBarcode);
	
	@Query("select i from Item i where i.itemName = ?1 and not i.recordState = 'deleted'")
	Item findByItemName(String itemName);
	
	@Query("select i from Item i join i.itemGroup g where g.groupName = ?1 and not i.recordState = 'deleted'")
	List<Item> findByGroupName(String groupName);
	
	@Query("select i from Item i join i.itemSubGroup g where g.subGroupName = ?1 and not i.recordState = 'deleted'")
	List<Item> findBySubGroupName(String subGroupName);
		
	@Query("select new com.wingcode.suppermarket.model.ItemCriteria(i.itemId, i.itemCode, i.itemBarcode, i.itemName) from Item i where not i.recordState = 'deleted'")
	List<ItemCriteria> getAllByItemIdCodeBarcodeAndName();
}
