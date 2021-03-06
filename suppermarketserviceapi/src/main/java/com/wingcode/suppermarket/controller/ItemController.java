package com.wingcode.suppermarket.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.InvalidDetailsException;
import com.wingcode.suppermarket.exception.ResourceAlreadyExistException;
import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.Item;
import com.wingcode.suppermarket.model.ItemCriteria;
import com.wingcode.suppermarket.model.ItemGroup;
import com.wingcode.suppermarket.model.ItemSubGroup;
import com.wingcode.suppermarket.model.StoreInfor;
import com.wingcode.suppermarket.model.Unit;
import com.wingcode.suppermarket.model.UnitOfMeasurement;
import com.wingcode.suppermarket.repository.ItemGroupRepository;
import com.wingcode.suppermarket.repository.ItemRepository;
import com.wingcode.suppermarket.repository.ItemSubGroupRepository;
import com.wingcode.suppermarket.repository.StoreInforRepository;
import com.wingcode.suppermarket.repository.UnitOfMeasurementRepository;
import com.wingcode.suppermarket.repository.UnitRepository;

@RestController
@RequestMapping("item/api/v1")
public class ItemController {

	@Autowired
	private ItemRepository itRepo;

	@Autowired
	private ItemGroupRepository igRepo;

	@Autowired
	private ItemSubGroupRepository isgRepo;

	@Autowired
	private StoreInforRepository siRepo;

	@Autowired
	private UnitRepository unRepo;
	
	@Autowired
	private UnitOfMeasurementRepository umRepo;
	
	/*
	 * Item Group Rest Controls 
	 */
	
	@GetMapping("/itemgroups")
	public List<ItemGroup> getAllItemGroup() {
		return igRepo.findAll();
	}

	@GetMapping("/itemgroups/{groupName}")
	public ItemGroup getByName(@PathVariable(value = "groupName") String groupName) {
		return igRepo.findByGroupName(groupName);
	}

	@PostMapping("/itemgroups")
	public ItemGroup createItemGroup(@Valid @RequestBody ItemGroup ig) {
		if (igRepo.findByGroupName(ig.getGroupName()) != null) {
			throw new ResourceAlreadyExistException("ItemGroup Already Exsist.");
		}
		ig.setCreatedAt(new Date());
		ig.setUpdatedAt(new Date());
		return igRepo.save(ig);
	}

	@PutMapping("/itemgroups/{id}")
	public ItemGroup updateItemGroup(@PathVariable(value = "id") Integer id, @Valid @RequestBody ItemGroup igp) {
		return igRepo.findById(id).map(ig -> {
			ig.setGroupName(igp.getGroupName());
			ig.setUpdatedAt(new Date());
			return igRepo.save(ig);
		}).orElseThrow(() -> throwResourceNotFoundException("GroupId", id.toString()));
	}
	
	@DeleteMapping("/itemgroups/{id}")
	public ResponseEntity<?> deleteItemGroup(@PathVariable(value = "id") Integer id) {
		return igRepo.findById(id).map(i -> {
			igRepo.delete(i);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("ItemSubGroupId", id.toString()));
	}

	/*
	 * Item Sub Group Rest Controls 
	 */	
	
	@GetMapping("/itemsubgroup")
	public List<ItemSubGroup> getAllSubItemGroup() {
		return isgRepo.findAll();
	}

	@GetMapping("/itemsubgroup/{subGroupName}")
	public ItemSubGroup getBySubName(@PathVariable(value = "subGroupName") String subGroupName) {
		return isgRepo.findBySubGroupName(subGroupName);
	}

	@PostMapping("/itemsubgroup")
	public ItemSubGroup createSubItemGroup(@Valid @RequestBody ItemSubGroup isg) {
		if (isgRepo.findBySubGroupName(isg.getSubGroupName()) != null) {
			throw new ResourceAlreadyExistException("ItemSubGroup Already Exsist.");
		}
		isg.setCreatedAt(new Date());
		isg.setUpdatedAt(new Date());
		return isgRepo.save(isg);
	}

	@PutMapping("/itemsubgroup/{id}")
	public ItemSubGroup updateSubItemGroup(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody ItemSubGroup isgp) {
		return isgRepo.findById(id).map(isg -> {
			isg.setSubGroupName(isgp.getSubGroupName());
			isg.setUpdatedAt(new Date());
			return isgRepo.save(isg);
		}).orElseThrow(() -> throwResourceNotFoundException("SubGroupId", id.toString()));
	}
	
	@DeleteMapping("/itemsubgroup/{id}")
	public ResponseEntity<?> deleteItemSubGroup(@PathVariable(value = "id") Integer id) {
		return isgRepo.findById(id).map(i -> {
			isgRepo.delete(i);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("ItemSubGroupId", id.toString()));
	}

	/*
	 * Item Rest Controls 
	 */
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		return itRepo.findAll();
	}

	@GetMapping("/items/attribs")
	public List<ItemCriteria> getAllItemsAttribs() {
		return itRepo.findAllIdCodeBarcodeAndName();
	}
	
	@GetMapping("/items/{param}/{paramValue}")
	public Item getByParam(@PathVariable(value = "param") String param,
			@PathVariable(value = "paramValue") String paramValue) {
		switch (param) {
		case "cd":
			return itRepo.findByCode(paramValue);
		case "bcd":
			return itRepo.findByBarcode(paramValue);
		case "nm":
			return itRepo.findByName(paramValue);
		default:
			return itRepo.findByCode(paramValue);
		}
	}

	@GetMapping("/items/lists/{param}/{name}")
	public List<Item> getByGroup(@PathVariable(value = "param") String param,
			@PathVariable(value = "name") String name) {
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
	public Item createItem(@Valid @RequestBody Item it) {
		if (itRepo.findByCode(it.getCode()) != null) {
			throw new ResourceAlreadyExistException("ItemSubGroup Already Exsist.");
		}
		it.setCreatedAt(new Date());
		it.setUpdatedAt(new Date());
		return itRepo.save(it);
	}

	@PutMapping("/items/{id}")
	public Item updateItem(@PathVariable(value = "id") Long id, @Valid @RequestBody Item it) {
		return itRepo.findById(id).map(i -> {
			i.setCategory(it.getCategory());
			i.setCode(it.getCode());
			i.setBarcode(it.getBarcode());
			i.setName(it.getName());
			i.setOtherName(it.getOtherName());
			i.setItemGroup(it.getItemGroup());
			i.setItemSubGroup(it.getItemSubGroup());
			i.setUnitOfMeasurement(it.getUnitOfMeasurement());
			i.setUpdatedAt(new Date());
			return itRepo.save(i);
		}).orElseThrow(() -> throwResourceNotFoundException("ItemId", id.toString()));
	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "id") Long id) {
		return itRepo.findById(id).map(i -> {
			itRepo.delete(i);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("ItemId", id.toString()));
	}

	/*
	 * Store Info Rest Controls 
	 */
	
	@GetMapping("/itemstores/{id}")
	public List<StoreInfor> getAllStoreInforByItemId(@PathVariable(value = "id") Long id) {
		return siRepo.findByItemId(id);
	}

	@GetMapping("/itemstores/{id}/{bid}")
	public StoreInfor getAllStoreInforByItemIdAndBranchId(@PathVariable(value = "id")Long id, 
			@PathVariable(value = "bid")Integer bid) {
		return siRepo.findByItemIdAndBranchId(id, bid);
	}
	
	@PostMapping("/itemstores")
	public StoreInfor createStoreInfor(@Valid @RequestBody StoreInfor st) {
		if(siRepo.findByItemIdAndBranchId(st.getItem().getId(), st.getBranch().getId()) != null) {
			throw new ResourceAlreadyExistException("ItemStoreInfor Already Exsist.");
		}
		st.setCreatedAt(new Date());
		st.setUpdatedAt(new Date());
		return siRepo.save(st);
	}
	
	@PutMapping("/itemstores/{id}")
	public StoreInfor updateStoreInfor(@PathVariable(value = "id") Long id, 
			@Valid @RequestBody StoreInfor st) {
		return siRepo.findById(id).map(s -> {
			s.setCost(st.getCost());
			s.setWholesalePrice(st.getWholesalePrice());
			s.setRetailPrice(st.getRetailPrice());
			s.setDiscount(st.getDiscount());
			s.setAvailableQuantity(st.getAvailableQuantity());
			s.setReorderLevel(st.getReorderLevel());
			s.setUpdatedAt(new Date());
			return siRepo.save(st);	
		}).orElseThrow(() -> throwResourceNotFoundException("StoreInforId", id.toString()));		
	}
	
	@DeleteMapping("/itemstores/{id}")
	public ResponseEntity<?> deleteItemStoreInfor(@PathVariable(value = "id") Long id) {
		return siRepo.findById(id).map(i -> {
			siRepo.delete(i);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("ItemitemstoresId", id.toString()));
	}
	
	/*
	 * Measure Rest Controls 
	 */
	
	@GetMapping("/units")
	public List<Unit> getAllUnit() {
		return unRepo.findAll();
	}
	
	@GetMapping("/units/type/{utype}")
	public List<Unit> getAllUnitByType(@PathVariable(value = "utype") String utype) {
		return unRepo.findByUnitType(utype);
	}
	
	@GetMapping("/units/name/{nam}")
	public Unit getAllUnitByName(@PathVariable(value = "nam") String nam) {
		return unRepo.findByUnitName(nam);
	}
	
	
	@PostMapping("/units")
	public Unit createUnit(@Valid @RequestBody Unit m) {
		if(m.getUnitName() == null) {
			throw new InvalidDetailsException("Unit Name Found Empty");
		}
		m.setCreatedAt(new Date());
		m.setUpdatedAt(new Date());
		return unRepo.save(m);
	}
	
	@PutMapping("/units/{id}")
	public Unit updateUnit(@PathVariable(value = "id") Integer id, 
			@Valid @RequestBody Unit me) {
		return unRepo.findById(id).map(m -> {
			m.setUnitName(me.getUnitName());
			m.setUnitType(me.getUnitType());
			m.setAbbreviation(me.getAbbreviation());
			m.setUpdatedAt(new Date());
			return unRepo.save(m);
		}).orElseThrow(() -> throwResourceNotFoundException("Measurement", id.toString()));
	}
	
	/*
	 * Unit Of Measure Rest Controls 
	 */
	
	@GetMapping("/uoms")
	public List<UnitOfMeasurement> getAllUnitOdMeasure() {
		return umRepo.findAll();
	}
	
	@GetMapping("/uoms/type/{utype}")
	public List<UnitOfMeasurement> getAllUnitOfMeasureByType(@PathVariable(value = "utype") String utype) {
		return umRepo.findByUnitType(utype);
	}
	
	@GetMapping("/uoms/description/{decs}")
	public UnitOfMeasurement getAllUnitUnitOfMeasureByDescription(@PathVariable(value = "decs") String decs) {
		return umRepo.findByUnitDescription(decs);
	}
	
	
	@PostMapping("/uoms")
	public UnitOfMeasurement createUnitOfMeasure(@Valid @RequestBody UnitOfMeasurement um) {
		if(um.getUnitDescription() == null) {
			throw new InvalidDetailsException("Unit Description Found Empty");
		}
		um.setCreatedAt(new Date());
		um.setUpdatedAt(new Date());
		return umRepo.save(um);
	}
	
	@PutMapping("/uoms/{id}")
	public UnitOfMeasurement updateUnitOfMeasure(@PathVariable(value = "id") Integer id, 
			@Valid @RequestBody UnitOfMeasurement um) {
		return umRepo.findById(id).map(u -> {
			u.setUnitDescription(um.getUnitDescription());
			u.setUnitType(um.getUnitType());
			u.setBaseUnitName(um.getBaseUnitName());
			u.setBasePrecision(um.getBasePrecision());
			u.setBaseRatio(um.getBaseRatio());
			u.setPurchaseUnitName(um.getPurchaseUnitName());
			u.setPurchasePrecision(um.getPurchasePrecision());
			u.setPurchasePrecisionUnitName(um.getPurchasePrecisionUnitName());
			u.setBaseRatioToPurchase(um.getBaseRatioToPurchase());
			u.setPurchaseQuantifyValue(um.getPurchaseQuantifyValue());
			u.setSaleUnitName(um.getSaleUnitName());
			u.setSalePrecision(um.getSalePrecision());
			u.setBaseRatioToSale(um.getBaseRatioToSale());
			u.setSaleOtherUnitName(um.getSaleOtherUnitName());
			u.setUpdatedAt(new Date());
			return umRepo.save(u);
		}).orElseThrow(() -> throwResourceNotFoundException("UnitOfMeasureId", id.toString()));
	}
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
