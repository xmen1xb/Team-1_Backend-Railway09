package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Product;

public interface IProductService {

	public Page<Product> getAllProducts(Pageable pageable);
	
	public Product getProductById(int id);
	
	public void deleteProduct(int id);
}
