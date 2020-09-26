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
import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.CashBook;
import com.wingcode.suppermarket.repository.CashBookRepository;

@RestController
@RequestMapping("cashbook/api/v1")
public class CashBookController {

	@Autowired
	private CashBookRepository cRepo;
	
	@GetMapping("/cashbooks/{trDate}")
	public List<CashBook> getCashBookByTransactionDate(@PathVariable(value = "trDate") Date trDate) {
		return cRepo.findByTransactionDate(trDate);
	}
	
	@GetMapping("/cashbooks/dec/{descript}")
	public List<CashBook> getCashBookByDescription(@PathVariable(value = "descript") String descript) {
		return cRepo.findByDescription(descript);
	}
	
	@PostMapping("/cashbooks")
	public CashBook createCashBook(@Valid @RequestBody CashBook c) {
		if(c.getTransactionDate() == null || c.getDescription() == null) {
			throw new InvalidDetailsException("TransactionDate or Description Found Empty");
		}
		c.setCreatedAt(new Date());
		c.setUpdatedAt(new Date());
		return cRepo.save(c);
	}
	
	@PutMapping("/cashbooks/{id}")
	public CashBook updateCashBook(@PathVariable(value = "id") Long id, @Valid @RequestBody CashBook c) {
		return cRepo.findById(id).map(r -> {
			r.setAmount(c.getAmount());
			r.setPurchase(c.getPurchase());
			r.setSaleInvoice(c.getSaleInvoice());
			r.setBranchAccount(c.getBranchAccount());
			r.setUpdatedAt(new Date());
			return cRepo.save(r);
		}).orElseThrow(() -> throwResourceNotFoundException("CashBookId", id.toString()));
	}
	
	@DeleteMapping("/cashbooks/{id}")
	public ResponseEntity<?> deleteCashBook(@PathVariable(value = "id") Long id) {
		return cRepo.findById(id).map(r -> {			
			cRepo.delete(r);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("CashBookId", id.toString()));
	}
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
