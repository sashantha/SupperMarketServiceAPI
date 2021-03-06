package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{
}
