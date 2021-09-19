package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.CartDetail;

public interface ICartDetailService {
	
	public Page<CartDetail> getAllCartDetail(Pageable pageable);
	
	public void createCartDetail(int producId, int accountId);
	
	public void deleteCartDetail(int id);
	
	public void updateCartDetailUp(int id);
	
	public void updateCartDetailDown(int id);
}
