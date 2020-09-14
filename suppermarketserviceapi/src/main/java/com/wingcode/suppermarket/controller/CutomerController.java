package com.wingcode.suppermarket.controller;

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
	
	@GetMapping("/customers/attribs")
	public List<CustomerCriteria> getAllCustomerIdCodeAndName() {
		return cusRepo.getAllByCustomerIdCodeAndName();
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer c) {		
		if(!validNewCustomer(c)) {
			throw new InvalidDetailsException("Customer Name precent empty.");
		}		
		return cusRepo.save(c);
	}
	
	private boolean validNewCustomer(Customer c) {
		return (c.getCustomerName() != null);	
	}
	
	@PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Customer c) {
        return cusRepo.findById(customerId).map(cus -> {
        	cus.setCustomerName(c.getCustomerName());
        	cus.setCustomerAddress(c.getCustomerAddress());
        	cus.setCustomerContact(c.getCustomerContact());
        	cus.setDescription(c.getDescription());
            return cusRepo.save(cus);
        }).orElseThrow(() -> throwResourceNotFoundException(customerId));
    }
	
	@PutMapping("/customers/{customerId}/{customerCode}")
    public Customer updateCustomerCode(@PathVariable(value = "customerId") Long customerId, @PathVariable(value = "customerCode") String customerCode) {
        return cusRepo.findById(customerId).map(sup -> {
        	sup.setCustomerCode(customerCode);
            return cusRepo.save(sup);
        }).orElseThrow(() -> throwResourceNotFoundException(customerId));
    }
	
	@DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "customerId") Long customerId) {
        return cusRepo.findById(customerId).map(c -> {
        	cusRepo.delete(c);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> throwResourceNotFoundException(customerId));
    }
	
	private ResourceNotFoundException throwResourceNotFoundException(Long customerId) {
		return new ResourceNotFoundException("SupplierId " + customerId + " not found");
	}
}
