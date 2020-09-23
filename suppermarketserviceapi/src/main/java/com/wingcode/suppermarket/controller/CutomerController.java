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
import com.wingcode.suppermarket.model.Customer;
import com.wingcode.suppermarket.model.CustomerCriteria;
import com.wingcode.suppermarket.repository.CustomerRepository;

@RestController
@RequestMapping("customer/api/v1")
public class CutomerController {

	@Autowired
	private CustomerRepository cusRepo;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return cusRepo.findAll();
	}
		
	@GetMapping("/customers/{branchId}")
	public List<Customer> getCustomerByBranchId(@PathVariable(value = "branchId") Integer branchId) {
		return cusRepo.findAllByBranchId(branchId);
	}
	
	@GetMapping("/customers/attribs/{branchId}")
	public List<CustomerCriteria> getAllIdCodeAndNameInBranch(@PathVariable(value = "branchId") Integer branchId) {
		return cusRepo.findAllCustomerIdCodeAndNameByBranchId(branchId);
	}

	@GetMapping("/customers/{id}/{branchId}")
	public Customer getCustomerByIdAndBranchId(@PathVariable(value = "id") Long id,
			@PathVariable(value = "branchId") Integer branchId) {
		return cusRepo.findByIdAndBranchId(id, branchId);
	}

	@GetMapping("/customers/{flag}/{paramVal}/{branchId}")
	public Customer getCustomerByCodeOrNameAndBranchId(@PathVariable(value = "flag") String flag,
			@PathVariable(value = "paramVal") String paramVal, @PathVariable(value = "branchId") Integer branchId) {
		switch (flag) {
		case "cc":
			return cusRepo.findByCodeAndBranchId(paramVal, branchId);
		case "cn":
			return cusRepo.findByNameAndBranchId(paramVal, branchId);
		default:
			return cusRepo.findByCodeAndBranchId(paramVal, branchId);
		}
	}

	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer c) {
		if (!validNewCustomer(c)) {
			throw new InvalidDetailsException("Customer Name found empty.");
		}
		c.setCreatedAt(new Date());
		c.setUpdatedAt(new Date());
		return cusRepo.save(c);
	}

	private boolean validNewCustomer(Customer c) {
		return (c.getName() != null);
	}

	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@PathVariable(value = "customerId") Long customerId,
			@Valid @RequestBody Customer c) {
		return cusRepo.findById(customerId).map(cus -> {
			if (cus.getCode() == null) {
				cus.setCode(c.getCode());
			}
			cus.setName(c.getName());
			cus.setAddress(c.getAddress());
			cus.setContact(c.getContact());
			cus.setDescription(c.getDescription());
			cus.setUpdatedAt(new Date());
			return cusRepo.save(cus);
		}).orElseThrow(() -> throwResourceNotFoundException("CustomerId", customerId.toString()));
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "customerId") Long customerId) {
		return cusRepo.findById(customerId).map(c -> {
			cusRepo.delete(c);
			return ResponseEntity.ok(1);
		}).orElseThrow(() -> throwResourceNotFoundException("CustomerId", customerId.toString()));
	}

	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
