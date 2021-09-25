package com.vti.service;

import java.util.List;

import com.vti.entity.Brand;

public interface IProductBrandService {

	Brand findById(Long id);
	
	void delete(Long id);
	
	List<Brand> showAll();
	
	void add(Brand Brand);
	
	Brand findByName(String name);
}
