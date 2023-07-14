package com.unir.springboot.app.msitem.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unir.springboot.app.msitem.models.Product;

@FeignClient(name = "service-msproducts")
public interface ProductClientRest {
	
	@GetMapping("/listar")
	public List<Product> listar();
	
	@GetMapping("/ver/{id}")
	public Product ver(@PathVariable Long id);
	
	
}
