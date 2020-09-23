package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.SupplierCreditAccount;

@Repository
public interface SupplierCreditAccountRepository extends JpaRepository<SupplierCreditAccount, Long> {
}
