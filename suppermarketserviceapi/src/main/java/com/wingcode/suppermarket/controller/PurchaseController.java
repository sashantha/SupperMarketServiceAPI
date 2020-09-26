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
	
	@GetMapping("/purchases/items/{purchaseId}")
	public List<PurchaseItem> getByByPurchaseId(@PathVariable(value = "purchaseId") Long purchaseId) {
		return puriRepo.findByPurchaseId(purchaseId);
	}

	@GetMapping("/purchases/items/item/{id}")
	public List<PurchaseItem> getByItemCode(@PathVariable(value = "id") Long id) {
		return puriRepo.findByItemId(id);
	}
	
	/*
	 * Purchase Rest Controls
	 */
	
	@GetMapping("/purchases")
	public List<Purchase> getAllPurchase() {
		return purRepo.findAll();
	}

	@GetMapping("/purchases/suppliers/{id}")
	public List<Purchase> getPurchaseBySupplierId(@PathVariable(value = "id") Long id) {
		return purRepo.findBySuplierId(id);		
	}

	@GetMapping("/purchases/{id}")
	public Purchase getPurchaseByPurchaseId(@PathVariable(value = "id") Long id) {
		return purRepo.findByPurchaseId(id);		
	}
	
	@GetMapping("/purchases/Invoices/{inv}")
	public Purchase getPurchaseByPurchaseInvoiceNo(@PathVariable(value = "inv") String inv) {
		return purRepo.findByInvoiceNo(inv);
	}
	
	@GetMapping("/purchases/dates/{date}")
	public List<Purchase> getPurchaseByDate(@PathVariable(value = "date") Date date) {
		return purRepo.findByPurchaseDate(date);
	}

	@GetMapping("/purchases/daymonths/{day}/{month}")
	public List<Purchase> getPurchaseByDayAndMonth(@PathVariable(value = "day") Integer day, 
			@PathVariable(value = "month") Integer month) {
		return purRepo.findByPurchaseDayAndMonth(day, month);
	}

	@GetMapping("/purchases/monthyears/{month}/{year}")
	public List<Purchase> getPurchaseByMonthAndYear(@PathVariable(value = "month") Integer month, 
			@PathVariable(value = "year") Integer year) {
		return purRepo.findByPurchaseMonth(month, year);
	}
	
	@GetMapping("/purchases/years/{year}")
	public List<Purchase> getPurchaseByYear(@PathVariable(value = "year") Integer year) {
		return purRepo.findByPurchaseYear(year);
	}

	@PostMapping("/purchases")
	public Purchase createPurchase(@Valid @RequestBody Purchase p) {
		return purRepo.save(p);
	}

	@PutMapping("/purchases/{purchaseId}")
	public Purchase updatePurchase(@PathVariable Long purchaseId,
			@Valid @RequestBody Purchase pu) {
		return purRepo.findById(purchaseId).map(p -> {
			p.setSupplier(pu.getSupplier());
			p.setInvoiceNo(pu.getInvoiceNo());
			p.setPurchaseDate(pu.getPurchaseDate());
			p.setInvoiceType(pu.getInvoiceType());
			p.setCostAmount(pu.getCostAmount());
			p.setInvoiceAmount(pu.getInvoiceAmount());
			p.setPurchaseDiscount(pu.getPurchaseDiscount());
			p.setDiscountPercent(pu.getDiscountPercent());
			p.setNetAmount(pu.getNetAmount());
			p.setPayAmount(pu.getPayAmount());
			p.setPayMethod(pu.getPayMethod());
			p.setCreditAmount(pu.getCreditAmount());
			p.setTotalPurchaseItem(pu.getTotalPurchaseItem());
			p.setRecordState(pu.getRecordState());
			p.setUpdatedAt(new Date());
			p.setUser(pu.getUser());
			return purRepo.save(p);
		}).orElseThrow(() -> throwResourceNotFoundException("PurchaseId", purchaseId.toString()));
	}

	@DeleteMapping("/purchases/{purchaseId}")
	public Purchase deletePurchase(@PathVariable(value = "purchaseId") Long purchaseId) {
		return purRepo.findById(purchaseId).map(p -> {
			p.setRecordState("deleted");
			p.setUpdatedAt(new Date());
			return purRepo.save(p);
		}).orElseThrow(() -> throwResourceNotFoundException("PurchaseId", purchaseId.toString()));
	}

	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
