package com.wingcode.suppermarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.CashBook;

@Repository
public interface CashBookRepository extends JpaRepository<CashBook, Long>{

	List<CashBook> findByTransactionDate(Date transactionDate);

	List<CashBook> findByDescription(String description);
}
