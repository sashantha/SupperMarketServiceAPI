package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.name = ?1")
	User findByName(String name);
	
	@Query("select u from User u where u.email = ?1")
	User findByEmail(String email);
}
