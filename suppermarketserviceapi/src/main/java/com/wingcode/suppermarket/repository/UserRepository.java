package com.wingcode.suppermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u join u.branch b where b.id = ?2 and u.name = ?1")
	User findByNameAndBranchId(String name, Integer branchId);
	
	@Query("select u from User u join u.branch b where b.id = ?2 and u.email = ?1")
	User findByEmailAndBranchId(String email, Integer branchId);
	
	@Query("select u from User u join u.branch b where b.id = ?1")
	List<User> findByBranchId(Integer branchId);
}
