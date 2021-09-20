package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.ProductImage;
import com.vti.repository.IProductImageRepository;
import com.vti.repository.IProductRepository;

@Service
public class ProductImageService implements IProductImageService{

	@Autowired
	private IProductImageRepository imageRepo;
	
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public List<ProductImage> getAllProductImage() {
		
		return null;
	}

}
