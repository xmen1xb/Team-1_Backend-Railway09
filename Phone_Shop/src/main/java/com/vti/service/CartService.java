package com.vti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Cart;
import com.vti.repository.ICartRepository;

@Service
public class CartService implements ICartService{

	@Autowired
	ICartRepository cartRepository;

	public Cart getCartUser(Long id) {
		return cartRepository.getCartUser(id);
	}

	public Cart save(Cart entity) {
		return cartRepository.save(entity);
	}

	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	public Optional<Cart> findById(Long id) {
		return cartRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return cartRepository.existsById(id);
	}

	public long count() {
		return cartRepository.count();
	}

	public void deleteById(Long id) {
		cartRepository.deleteById(id);
	}

	public void deleteAll() {
		cartRepository.deleteAll();
	}

	public Cart getById(Long id) {
		return cartRepository.getById(id);
	}
	
}
