package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.CartDetail;

public interface ICartDetailService {

	public Page<CartDetail> getAllCartDetail(Pageable pageable);
	
	public void createCartDetail();
	
	public void deleteCartDetail(int id);
}
