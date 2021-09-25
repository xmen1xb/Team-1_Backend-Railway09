package com.vti.service;

import java.util.List;
import java.util.Optional;

import com.vti.entity.CartDetail;

public interface ICartDetailService {
	
	public boolean existsById(Long id);
	public Optional<CartDetail> findById(Long id);
	public List<CartDetail> getByCartId(Long id);
	public CartDetail save(CartDetail entity);
	public void deleteById(Long id);
}
