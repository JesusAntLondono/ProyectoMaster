package com.unir.springboot.app.msproducts.models.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unir.springboot.app.msproducts.models.entity.Product;

public interface ProductDao extends MongoRepository<Product, Long> {
	

}
