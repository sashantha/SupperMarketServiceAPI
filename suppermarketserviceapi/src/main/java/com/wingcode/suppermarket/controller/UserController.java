package com.wingcode.suppermarket.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.wingcode.suppermarket.model.User;
import com.wingcode.suppermarket.repository.UserRepository;

@RestController
@RequestMapping("user/api/v1")
public class UserController {

	@Autowired
	private UserRepository usRepo;
		
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return usRepo.findAll();
	}
	
	@GetMapping("/users/{branchId}")
	public List<User> getAllUsersInBranch(@PathVariable(value = "branchId") Integer branchId) {
		return usRepo.findByBranchId(branchId);
	}
	
	@GetMapping("/users/{param}/{branchId}")
	public User getUserByName(@PathVariable(value = "param") String param, 
			@PathVariable(value = "branchId") Integer branchId) {
		if(param.endsWith(".com")) {
			return usRepo.findByEmailAndBranchId(param, branchId);
		}else {
			return usRepo.findByNameAndBranchId(param, branchId);
		}		
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User u) {		
		if(!validNewUser(u)) {
			throw new InvalidDetailsException("Some user details precent empty.");
		}
		if(usRepo.findByNameAndBranchId(u.getName(), u.getBranch().getId()) != null) {
			throw new ResourceAlreadyExistException(u.getName() + "Alredy Exist.");
		}		
		u.setCreatedAt(new Date());
		u.setUpdatedAt(new Date());
		return usRepo.save(u);		
	}
	
	private boolean validNewUser(User u) {
		return (u.getName() != null || u.getEmail() != null || u.getPassword() != null || u.getUserRole() != null);	
	}
	
	@PutMapping("/users/{userId}")
    public User updateUser(@PathVariable(value = "userId") Integer userId, @Valid @RequestBody User u) {
        return usRepo.findById(userId).map(fu -> {
        	fu.setName(u.getName());
        	fu.setEmail(u.getEmail());
        	fu.setPassword(u.getPassword());
    		u.setUpdatedAt(new Date());
            return usRepo.save(fu);
        }).orElseThrow(() -> throwResourceNotFoundException("UserId", userId.toString()));
    }
	
	@DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        return usRepo.findById(userId).map(user -> {
        	usRepo.delete(user);
            return ResponseEntity.ok(1);
        }).orElseThrow(() -> throwResourceNotFoundException("UserId", userId.toString()));
    }
	
	private ResourceNotFoundException throwResourceNotFoundException(String proName, String id) {
		return new ResourceNotFoundException(proName + " " + id + " not found");
	}
}
