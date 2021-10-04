package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.ProductRam;
import com.vti.repository.IProductRamRepository;

@Service
public class ProductRamService implements IProductRamService{

	@Autowired
	private IProductRamRepository productRamRepo;
	
	@Override
	public List<ProductRam> getAllProductRam() {
		
		return productRamRepo.findAll();
	}

}
