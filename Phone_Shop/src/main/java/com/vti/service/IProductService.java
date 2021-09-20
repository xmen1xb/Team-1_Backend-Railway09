package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Product;
import com.vti.request.ProductFilterRequest;

public interface IProductService {

	public Page<Product> getAllProducts(Pageable pageable, String search, ProductFilterRequest filter);
	
	public Product getProductById(int id);
	
	public void deleteProduct(int id);
}
