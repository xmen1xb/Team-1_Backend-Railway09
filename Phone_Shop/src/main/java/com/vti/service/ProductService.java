package com.vti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Product;
import com.vti.repository.IProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product findById(Long id) {
		return productRepository.findByProductId(id);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> showAll() {
		return productRepository.findAllProduct();
	}

	@Override
	public List<Product> getAllByCategory(Long id) {
		return productRepository.findAllProductByCategoryId(id);
	}

	@Override
	@Transactional
	public void add(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.getById(id);
	}


}
