package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.CashBook;

@Repository
public interface CashBookRepository extends JpaRepository<CashBook, Long>{
}
