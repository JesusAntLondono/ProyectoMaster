package com.unir.springboot.app.msproducts.models.service;

import java.util.List;

import com.unir.springboot.app.msproducts.models.entity.Product;

public interface IProductService {
	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public Product save(Product product);
	
	public void deleteById(Long id);
}
