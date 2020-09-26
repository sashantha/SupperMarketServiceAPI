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
import com.wingcode.suppermarket.model.Bank;
import com.wingcode.suppermarket.repository.BankRepository;

@RestController
@RequestMapping("bank/api/v1")
public class BankController {

	@Autowired
	private BankRepository bRepo;
	
	/*
	 * Bank Rest Control
	 */
	
	@GetMapping("/banks")
	public List<Bank> getAllBanks() {
		return bRepo.findAll();
	}
	
	@PostMapping("/banks")
	public Bank createBank(@Valid @RequestBody Bank b) {
		if(b.getName() == null) {
			throw new InvalidDetailsException("Bank Name Found Empty");
		}
		b.setCreatedAt(new Date());
		b.setUpdatedAt(new Date());
		return bRepo.save(b);
	}
	
	@PutMapping("/banks/{id}")
	public Bank updateBank(@PathVariable(value = "id") Integer id, @Valid @RequestBody Bank b) {
		return bRepo.findById(id).map(r -> {
			r.setName(b.getName());
			r.setUpdatedAt(new Date());
			return bRepo.save(r);
		}).orElseThrow(() -> throwResourceNotFoundException("BankId", id.toString()));
	}
	
	@DeleteMapping("/banks/{id}")
	public ResponseEntity<?> deleteBank(@PathVariable(value = "id")  Integer id) {
		return bRepo.findById(id).map(r -> {
			bRepo.delete(r);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("BankId", id.toString()));
	}
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
