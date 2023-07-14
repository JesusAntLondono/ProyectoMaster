package com.unir.springboot.app.msitem.service;

import java.util.List;

import com.unir.springboot.app.msitem.models.Item;

public interface IItemService {
	public List<Item> findAll();
	public Item findById(Long id, Integer quantity);
}
