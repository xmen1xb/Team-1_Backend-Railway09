package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Brand;
import com.vti.repository.IProductBrandRepository;

@Service
public class ProductBrandService implements IProductBrandService{

	@Autowired
	private IProductBrandRepository productBrandRepository;

	@Override
	public Brand findById(Long id) {
		return productBrandRepository.findByCategoryId(id);
	}
	
	@Override
	public void delete(Long id) {
		productBrandRepository.deleteById(id);
	}

	@Override
	public List<Brand> showAll() {
		return productBrandRepository.findAllCategory();
	}

	@Override
	public void add(Brand category) {
		productBrandRepository.save(category);
	}


	@Override
	public Brand findByName(String name) {
		return productBrandRepository.findByName(name);
	}

}
