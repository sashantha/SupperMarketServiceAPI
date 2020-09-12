package com.wingcode.suppermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingcode.suppermarket.repository.ItemGroupRepository;
import com.wingcode.suppermarket.repository.ItemRepository;
import com.wingcode.suppermarket.repository.ItemSubGroupRepository;

@RestController
@RequestMapping("item/api/v1")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private ItemGroupRepository igRepo;
	
	@Autowired
	private ItemSubGroupRepository isgRepo;
}
