package com.wingcode.suppermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingcode.suppermarket.model.ItemGroup;

@Repository
public interface ItemGroupRepository extends JpaRepository<ItemGroup, String>{

}
