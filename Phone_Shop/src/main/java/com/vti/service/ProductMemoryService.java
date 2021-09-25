package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Memory;
import com.vti.repository.IProductMemoryRepository;

@Service
public class ProductMemoryService implements IProductMemoryService{

	@Autowired
	private IProductMemoryRepository productMemoryRepo;
	
	@Override
	public List<Memory> getAllProductMemory() {
		
		return productMemoryRepo.findAll();
	}

}
