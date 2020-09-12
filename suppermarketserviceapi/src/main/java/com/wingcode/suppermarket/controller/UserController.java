package com.wingcode.suppermarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.exception.InvalidDetailsException;
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
	
	@GetMapping("/users/{param}")
	public User getUserByName(@PathVariable(value = "param") String param) {
		if(param.endsWith(".com")) {
			return usRepo.findByEmail(param);
		}else {
			return usRepo.findByName(param);
		}
		
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User u) {		
		if(!validNewUser(u)) {
			throw new InvalidDetailsException("Some user details precent empty.");
		}		
		return usRepo.save(u);
	}
	
	private boolean validNewUser(User u) {
		return (u.getName() != null || u.getEmail() != null || u.getPassword() != null || u.getUserRole() != null);	
	}
}
