package com.wingcode.suppermarket.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.ResourceAlreadyExistException;
import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.Item;
import com.wingcode.suppermarket.model.ItemGroup;
import com.wingcode.suppermarket.model.ItemSubGroup;
import com.wingcode.suppermarket.repository.ItemGroupRepository;
import com.wingcode.suppermarket.repository.ItemRepository;
import com.wingcode.suppermarket.repository.ItemSubGroupRepository;

@RestController
@RequestMapping("item/api/v1")
public class ItemController {

	@Autowired
	private ItemRepository itRepo;

	@Autowired
	private ItemGroupRepository igRepo;

	@Autowired
	private ItemSubGroupRepository isgRepo;

	@GetMapping("/itemgroups")
	public List<ItemGroup> getAllItemGroup() {
		return igRepo.findAll();
	}

	@GetMapping("/itemgroups/{groupName}")
	public ItemGroup getByName(@PathVariable(value = "groupName") String groupName) {
		return igRepo.getByGroupName(groupName);
	}

	@PostMapping("/itemgroups")
	public ItemGroup createItemGroup(@Valid @RequestBody ItemGroup itemGroup) {
		if (igRepo.existsById(itemGroup.getGroupName())) {
			throw new ResourceAlreadyExistException("ItemGroup Already Exsist.");
		}
		return igRepo.save(itemGroup);
	}

	@PutMapping("/itemgroups/{groupName}")
	public ItemGroup updateItemGroup(@PathVariable(value = "groupName") String groupName,
			@Valid @RequestBody ItemGroup itemGroup) {
		return igRepo.findById(groupName).map(ig -> {
			ig.setGroupName(itemGroup.getGroupName());
			return igRepo.save(ig);
		}).orElseThrow(() -> throwResourceNotFoundException("GroupName", groupName));
	}

	@GetMapping("/itemsubgroup")
	public List<ItemSubGroup> getAllSubItemGroup() {
		return isgRepo.findAll();
	}

	@GetMapping("/itemsubgroup/{subGroupName}")
	public ItemSubGroup getBySubName(@PathVariable(value = "subGroupName") String subGroupName) {
		return isgRepo.getBySubGroupName(subGroupName);
	}

	@PostMapping("/itemsubgroup")
	public ItemSubGroup createSubItemGroup(@Valid @RequestBody ItemSubGroup itemSubGroup) {
		if (isgRepo.existsById(itemSubGroup.getSubGroupName())) {
			throw new ResourceAlreadyExistException("ItemSubGroup Already Exsist.");
		}
		return isgRepo.save(itemSubGroup);
	}

	@PutMapping("/itemsubgroup/{subGroupName}")
	public ItemSubGroup updateSubItemGroup(@PathVariable(value = "subGroupName") String subGroupName,
			@Valid @RequestBody ItemSubGroup itemSubGroup) {
		return isgRepo.findById(subGroupName).map(isg -> {
			isg.setSubGroupName(itemSubGroup.getSubGroupName());
			return isgRepo.save(isg);
		}).orElseThrow(() -> throwResourceNotFoundException("SubGroupName", subGroupName));
	}

	@GetMapping("/items")
	public List<Item> getAllItems() {
		return itRepo.findAll();
	}

	@GetMapping("/items/{param}/{paramValue}")
	public Item getByParam(@PathVariable(value = "param") String param, @PathVariable(value = "paramValue") String paramValue) {
		switch (param) {
		case "cd":
			return itRepo.findByItemCode(paramValue);			
		case "bcd":
			return itRepo.findByItemBarcode(paramValue);
		case "nm":
			return itRepo.findByItemName(paramValue);			
		default:			
			return itRepo.findByItemCode(paramValue);
		}		
	}
	
	@GetMapping("/items/{param}/{name}")
	public List<Item> getByGroup(@PathVariable(value = "param") String param, @PathVariable(value = "name") String name) {
		switch (param) {
		case "ig":
			return itRepo.findByGroupName(name);
		case "isg":
			return itRepo.findBySubGroupName(name);			
		default:
			return itRepo.findByGroupName(name);
		}
	}
	
	@PostMapping("/items")
	public Item createItem(@Valid @RequestBody Item item) {
		item.setRecordState("fine");
		item.setOnUpdated(new Date());
		return itRepo.save(item);
	}

	@PutMapping("/items/{itemId}")
	public Item updateItem(@PathVariable(value = "itemId") Long itemId, @Valid @RequestBody Item item) {
		return itRepo.findById(itemId).map(i -> {
			i.setItemName(item.getItemName());
			i.setItemGroup(item.getItemGroup());
			i.setItemSubGroup(item.getItemSubGroup());
			i.setItemCost(item.getItemCost());
			i.setItemWholesalePrice(item.getItemWholesalePrice());
			i.setItemRetailPrice(item.getItemRetailPrice());
			i.setItemDiscount(item.getItemDiscount());
			i.setAvailableQuantity(item.getAvailableQuantity());
			i.setReorderLevel(item.getReorderLevel());
			i.setRecordState(item.getRecordState());
			i.setOnUpdated(item.getOnUpdated());
			return itRepo.save(i);
		}).orElseThrow(() -> throwResourceNotFoundException("ItemId", itemId.toString()));
	}
	
	@DeleteMapping("/items/{itemId}")
	public Item deleteItem(@PathVariable(value = "itemId") Long itemId) {
		return itRepo.findById(itemId).map(i -> {
			i.setRecordState("deleted");			
			return itRepo.save(i);
		}).orElseThrow(() -> throwResourceNotFoundException("ItemId", itemId.toString()));
	}
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
