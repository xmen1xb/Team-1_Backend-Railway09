package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.ProductBrand;
import com.vti.repository.IProductBrandRepository;

@Service
public class ProductBrandService implements IProductBrandService{

	@Autowired
	private IProductBrandRepository productBrandRepo;
	
	@Override
	public List<ProductBrand> getAllProductBrand() {
		
		return productBrandRepo.findAll();
	}

}
