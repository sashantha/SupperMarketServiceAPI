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
import com.wingcode.suppermarket.model.ChequeBook;
import com.wingcode.suppermarket.repository.ChequeBookRepository;

@RestController
@RequestMapping("chequebook/api/v1")
public class ChequeBookController {

	@Autowired
	private ChequeBookRepository cqRepo;
	
	@GetMapping("/chequebooks/trd/{trDate}")
	public List<ChequeBook> getChequeBookByTransactionDate(@PathVariable(value = "trDate") Date trDate) {
		return cqRepo.findByTransactionDate(trDate);
	}
	
	@GetMapping("/chequebooks/dec/{descript}")
	public List<ChequeBook> getChequeBookByDescription(@PathVariable(value = "descript") String descript) {
		return cqRepo.findByDescription(descript);
	}
	
	@PostMapping("/chequebooks")
	public ChequeBook createChequeBook(@Valid @RequestBody ChequeBook c) {
		if(c.getTransactionDate() == null || c.getDescription() == null) {
			throw new InvalidDetailsException("TransactionDate or Description Found Empty");
		}
		c.setCreatedAt(new Date());
		c.setUpdatedAt(new Date());
		return cqRepo.save(c);
	}
	
	@PutMapping("/chequebooks/{id}")
	public ChequeBook updateChequeBook(@PathVariable(value = "id") Long id, @Valid @RequestBody ChequeBook c) {
		return cqRepo.findById(id).map(r -> {
			r.setChequeAmount(c.getChequeAmount());
			r.setPurchase(c.getPurchase());
			r.setSaleInvoice(c.getSaleInvoice());
			r.setBranchAccount(c.getBranchAccount());
			r.setUpdatedAt(new Date());
			return cqRepo.save(r);
		}).orElseThrow(() -> throwResourceNotFoundException("CashBookId", id.toString()));
	}
	
	@DeleteMapping("/chequebooks/{id}")
	public ResponseEntity<?> deleteChequeBook(@PathVariable(value = "id") Long id) {
		return cqRepo.findById(id).map(r -> {			
			cqRepo.delete(r);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("CashBookId", id.toString()));
	}
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}	
}
