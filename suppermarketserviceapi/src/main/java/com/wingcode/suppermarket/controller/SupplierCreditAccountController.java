package com.wingcode.suppermarket.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.ResourceNotFoundException;
import com.wingcode.suppermarket.model.SupplierCreditAccount;
import com.wingcode.suppermarket.repository.SupplierCreditAccountRepository;

@RestController
@RequestMapping("suppliercreditac/api/v1")
public class SupplierCreditAccountController {

	@Autowired
	private SupplierCreditAccountRepository repo;
	
	@PostMapping("/suppliercac")
	public SupplierCreditAccount createSupplierCrediAccount(@Valid @RequestBody SupplierCreditAccount sac) {
		sac.setCreatedAt(new Date());
		sac.setUpdatedAt(new Date());
		return repo.save(sac);
	}
	
	@PutMapping("/suppliercac/{id}")
	public SupplierCreditAccount updateSupplierCrediAccount(@PathVariable(value = "id") Long id, 
			@Valid @RequestBody SupplierCreditAccount sac) {
		return repo.findById(id).map(sc -> {
			sc.setTotalCredit(sac.getTotalCredit());
			sc.setUpdatedAt(new Date());
			return repo.save(sc);
		}).orElseThrow(() -> throwResourceNotFoundException("Supplier Credit Account Id", id.toString()));
	}
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
