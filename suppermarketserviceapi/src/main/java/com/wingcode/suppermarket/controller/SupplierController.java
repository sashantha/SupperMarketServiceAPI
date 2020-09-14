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
import com.wingcode.suppermarket.model.Supplier;
import com.wingcode.suppermarket.model.SupplierCriteria;
import com.wingcode.suppermarket.repository.SupplierRepository;

@RestController
@RequestMapping("supplier/api/v1")
public class SupplierController {

	
	@Autowired
	private SupplierRepository supRepo;
	
	@GetMapping("/suppliers")
	public List<Supplier> getAllSuppliers() {
		return supRepo.findAll();
	}
	
	@GetMapping("/suppliers/attribs")
	public List<SupplierCriteria> getAllSuppliersIdCodeAndName() {
		return supRepo.getAllBySupplierIdCodeAndName();
	}
	
	@PostMapping("/suppliers")
	public Supplier createSupplier(@Valid @RequestBody Supplier s) {		
		if(!validNewSupplier(s)) {
			throw new InvalidDetailsException("Supplier Name precent empty.");
		}		
		return supRepo.save(s);
	}
	
	private boolean validNewSupplier(Supplier s) {
		return (s.getSupplierName() != null);	
	}
	
	@PutMapping("/suppliers/{supplierId}")
    public Supplier updateSupplier(@PathVariable(value = "supplierId") Long supplierId, @Valid @RequestBody Supplier s) {
        return supRepo.findById(supplierId).map(sup -> {
        	sup.setSupplierName(s.getSupplierName());
        	sup.setSupplierAddress(s.getSupplierAddress());
        	sup.setSupplierContact(s.getSupplierContact());
        	sup.setDescription(s.getDescription());
            return supRepo.save(sup);
        }).orElseThrow(() -> throwResourceNotFoundException(supplierId));
    }
	
	@PutMapping("/suppliers/{supplierId}/{supplierCode}")
    public Supplier updateSupplierCode(@PathVariable(value = "supplierId") Long supplierId, @PathVariable(value = "supplierCode") String supplierCode) {
        return supRepo.findById(supplierId).map(sup -> {
        	sup.setSuplierCode(supplierCode);
            return supRepo.save(sup);
        }).orElseThrow(() -> throwResourceNotFoundException(supplierId));
    }
	
	@DeleteMapping("/suppliers/{supplierId}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(value = "supplierId") Long supplierId) {
        return supRepo.findById(supplierId).map(s -> {
        	supRepo.delete(s);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> throwResourceNotFoundException(supplierId));
    }
	
	private ResourceNotFoundException throwResourceNotFoundException(Long supplierId) {
		return new ResourceNotFoundException("SupplierId " + supplierId + " not found");
	}
}
