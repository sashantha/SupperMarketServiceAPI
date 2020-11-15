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

import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.Purchase;
import com.wingcode.suppermarket.model.PurchaseItem;
import com.wingcode.suppermarket.repository.PurchaseItemRepository;
import com.wingcode.suppermarket.repository.PurchaseRepository;

@RestController
@RequestMapping("purchasing/api/v1")
public class PurchaseController {

	// private final

	@Autowired
	private PurchaseRepository purRepo;

	@Autowired
	private PurchaseItemRepository puriRepo;

	/*
	 * Purchase Item Rest Controls
	 */

	@GetMapping("/purchases/items/{bid}/{flag}/{paramid}")
	public List<PurchaseItem> getByParam(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "flag") String flag,
			@PathVariable(value = "paramid") Long paramid) {
		switch (flag) {
		case "pur":			
			return puriRepo.findByPurchaseId(bid, paramid);
		case "pit":
			return puriRepo.findByItemId(bid, paramid);
		default:
			return puriRepo.findByPurchaseId(bid, paramid);
		}
		
	}

	@GetMapping("/purchases/items/date/{bid}/{pdate}")
	public List<PurchaseItem> getByPurchaseDate(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "pdate") Date pdate) {
		return puriRepo.findByPurchaseDate(bid, pdate);
	}

	@GetMapping("/purchases/items/date/{bid}/{sdate}/{edate}")
	public List<PurchaseItem> getByEpireDate(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "sdate") Date sdate, 
			@PathVariable(value = "edate") Date edate) {
		return puriRepo.findByExpireDate(bid, sdate, edate);
	}	
	
	@PostMapping("/purchases/items")
	public PurchaseItem createPurchaseItem(@Valid @RequestBody PurchaseItem pi) {
		pi.setCreatedAt(new Date());
		pi.setUpdatedAt(new Date());
		return puriRepo.save(pi);
	}

	@PutMapping("/purchases/items/{id}")
	public PurchaseItem updatePurchaseItem(@PathVariable(value = "id") Long id, @Valid @RequestBody PurchaseItem pi) {
		return puriRepo.findById(id).map(p -> {
			p.setAmount(pi.getAmount());
			p.setCost(pi.getCost());
			p.setDiscount(pi.getDiscount());
			p.setExpireDate(pi.getExpireDate());
			p.setFreeQuantity(pi.getFreeQuantity());
			p.setManufactureDate(pi.getManufactureDate());
			p.setPurchaseDate(pi.getPurchaseDate());
			p.setPurchaseType(pi.getPurchaseType());
			p.setQuantity(pi.getQuantity());
			p.setRealQuantity(pi.getRealQuantity());
			p.setAvailableQuantity(pi.getAvailableQuantity());
			p.setReorderLevel(pi.getReorderLevel());
			p.setRetailPrice(pi.getRetailPrice());
			p.setWholesalePrice(pi.getWholesalePrice());
			p.setRecordState(pi.getRecordState());
			p.setItem(pi.getItem());
			p.setUpdatedAt(new Date());
			return puriRepo.save(p);
		}).orElseThrow(() -> throwResourceNotFoundException("PurchaseItemId", id.toString()));
	}

	@DeleteMapping("/purchases/items/{id}")
	public ResponseEntity<?> deletePurchaseItem(@PathVariable(value = "id") Long id) {
		return puriRepo.findById(id).map(i -> {
			puriRepo.delete(i);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("PurchaseItemId", id.toString()));
	}
	
	/*
	 * Purchase Rest Controls
	 */
	
	@GetMapping("/purchases/suppliers/{bid}/{id}")
	public List<Purchase> getPurchaseBySupplierId(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "id") Long id) {
		return purRepo.findBySuplierId(bid, id);
	}

	@GetMapping("/purchases/{bid}/{id}")
	public Purchase getPurchaseByPurchaseId(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "id") Long id) {
		return purRepo.findByPurchaseId(bid, id);
	}

	@GetMapping("/purchases/invs/{bid}/{inv}")
	public Purchase getPurchaseByPurchaseInvoiceNo(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "inv") String inv) {
		return purRepo.findByInvoiceNo(bid, inv);
	}
	
	@GetMapping("/purchases/invs/{bid}/{inv}/{rst}")
	public Purchase getPurchaseByPurchaseInvoiceNoAndRecordSt(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "inv") String inv, @PathVariable(value = "rst") String rst) {
		return purRepo.findByInvoiceNoAndRecordSt(bid, inv, rst);
	}

	@GetMapping("/purchases/dates/{bid}/{date}")
	public List<Purchase> getPurchaseByDate(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "date") Date date) {
		return purRepo.findByPurchaseDate(bid, date);
	}

	@GetMapping("/purchases/daymonths/{bid}/{day}/{month}")
	public List<Purchase> getPurchaseByDayAndMonth(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "day") Integer day,
			@PathVariable(value = "month") Integer month) {
		return purRepo.findByPurchaseDayAndMonth(bid, day, month);
	}

	@GetMapping("/purchases/monthyears/{bid}/{month}/{year}")
	public List<Purchase> getPurchaseByMonthAndYear(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "month") Integer month,
			@PathVariable(value = "year") Integer year) {
		return purRepo.findByPurchaseMonth(bid, month, year);
	}

	@GetMapping("/purchases/years/{bid}/{year}")
	public List<Purchase> getPurchaseByYear(@PathVariable(value = "bid") Integer bid, 
			@PathVariable(value = "year") Integer year) {
		return purRepo.findByPurchaseYear(bid, year);
	}

	@PostMapping("/purchases")
	public Purchase createPurchase(@Valid @RequestBody Purchase p) {
		p.setCreatedAt(new Date());
		p.setUpdatedAt(new Date());		
		return purRepo.save(p);
	}

	@PutMapping("/purchases/{purchaseId}")
	public Purchase updatePurchase(@PathVariable Long purchaseId, @Valid @RequestBody Purchase pu) {
		return purRepo.findById(purchaseId).map(p -> {
			p.setCostAmount(pu.getCostAmount());
			p.setCreditAmount(pu.getCreditAmount());
			p.setDiscountPercent(pu.getDiscountPercent());
			p.setInvoiceAmount(pu.getInvoiceAmount());
			p.setInvoiceNo(pu.getInvoiceNo());
			p.setInvoiceType(pu.getInvoiceType());
			p.setNetAmount(pu.getNetAmount());
			p.setPayAmount(pu.getPayAmount());
			p.setChqAmount(pu.getChqAmount());
			p.setPayMethod(pu.getPayMethod());
			p.setPurchaseDate(pu.getPurchaseDate());
			p.setPurchaseDiscount(pu.getPurchaseDiscount());
			p.setRecordState(pu.getRecordState());
			p.setTotalPurchaseItem(pu.getTotalPurchaseItem());
			p.setSupplier(pu.getSupplier());
			p.setUser(pu.getUser());			
			p.setUpdatedAt(new Date());
			return purRepo.save(p);
		}).orElseThrow(() -> throwResourceNotFoundException("PurchaseId", purchaseId.toString()));
	}

	@DeleteMapping("/purchases/{purchaseId}")
	public ResponseEntity<?> deletePurchase(@PathVariable(value = "purchaseId") Long purchaseId) {
		return purRepo.findById(purchaseId).map(i -> {
			purRepo.delete(i);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("PurchaseId", purchaseId.toString()));
	}
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
