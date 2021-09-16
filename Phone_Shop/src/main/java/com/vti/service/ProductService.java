package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Product;
import com.vti.repository.IProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductRepository product_repo;
	
	@Override
	public Page<Product> getAllProducts(Pageable pageable) {

		return product_repo.findAll(pageable);
	}

	@Override
	public Product getProductById(int id) {

		return product_repo.getById(id);
	}

}
