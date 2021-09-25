package com.vti.service;

import com.vti.entity.Cart;

public interface ICartService {
	
	public boolean existsById(Long id);
	public Cart save(Cart entity);
	public Cart getCartUser(Long id) ;

}
