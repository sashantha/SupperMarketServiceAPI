package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.ItemSubGroup;

@Repository
public interface ItemSubGroupRepository extends JpaRepository<ItemSubGroup, String>{

}
