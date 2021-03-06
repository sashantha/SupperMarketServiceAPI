package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.CustomerCreditAccount;

@Repository
public interface CustomerCreditAccountRepository extends JpaRepository<CustomerCreditAccount, Long> {	
}
