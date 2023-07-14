package com.unir.springboot.app.msitem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.springboot.app.msitem.clients.ProductClientRest;
import com.unir.springboot.app.msitem.models.Item;

@Service("serviceFeign")
public class ItemServiceFeign implements IItemService {
	
	@Autowired
	private ProductClientRest clientFeign;
	
	@Override
	public List<Item> findAll() {
		return clientFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(clientFeign.ver(id), quantity);
	}
}
