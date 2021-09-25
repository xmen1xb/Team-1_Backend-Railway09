package com.vti.service;

import java.util.List;

import com.vti.entity.Product;

public interface IProductService {
	
	Product findById(Long id);
	
	void delete(Long id);
	
	List<Product> showAll();
	
	List<Product> getAllByCategory(Long id);
	
	void add(Product product);
	
	Product getById(Long id);
}
