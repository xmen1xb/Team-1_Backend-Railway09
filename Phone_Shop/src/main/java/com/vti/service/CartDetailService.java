package com.vti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.CartDetail;
import com.vti.repository.ICartDetailRepository;

@Service
public class CartDetailService implements ICartDetailService {

	@Autowired
	 ICartDetailRepository cartDetailRepository;
	
	public List<CartDetail> getByCartId(Long id) {
		return cartDetailRepository.getByCartId(id);
	}
	public Long getCount(Long id) {
		return cartDetailRepository.getCount(id);
	}
	public CartDetail save(CartDetail entity) {
		return cartDetailRepository.save(entity);
	}
	public List<CartDetail> findAll() {
		return cartDetailRepository.findAll();
	}
	public Optional<CartDetail> findById(Long id) {
		return cartDetailRepository.findById(id);
	}
	public boolean existsById(Long id) {
		return cartDetailRepository.existsById(id);
	}
	public long count() {
		return cartDetailRepository.count();
	}
	public void deleteById(Long id) {
		cartDetailRepository.deleteById(id);
	}
	public void deleteAll() {
		cartDetailRepository.deleteAll();
	}
	public CartDetail getById(Long id) {
		return cartDetailRepository.getById(id);
	}	
}
