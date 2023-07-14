package com.unir.springboot.app.msproducts.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.springboot.app.msproducts.models.dao.ProductDao;
import com.unir.springboot.app.msproducts.models.entity.Product;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductDao productdao;

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		
		return (List<Product>)productdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productdao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		return productdao.save(product);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productdao.deleteById(id);
	}

}
