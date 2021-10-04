package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Cart;
import com.vti.repository.IAccountRepository;
import com.vti.repository.ICartRepository;

@Service
public class CartService implements ICartService{

	@Autowired
	private ICartRepository cartRepo;
	
	@Autowired
	private IAccountRepository accountRepo;

	@Override
	public Cart getCartbyId(int id) {
		Account account = accountRepo.getById(id);
		
		return cartRepo.getById(account.getAccountId());
	}

}
