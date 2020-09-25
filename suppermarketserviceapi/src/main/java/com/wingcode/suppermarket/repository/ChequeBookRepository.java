package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.ChequeBook;

@Repository
public interface ChequeBookRepository extends JpaRepository<ChequeBook, Long>{
}
