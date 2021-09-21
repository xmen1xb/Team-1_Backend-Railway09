package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Cart;
import com.vti.entity.Order;
import com.vti.repository.IAccountRepository;
import com.vti.repository.ICartRepository;
import com.vti.repository.IOrderRepository;
import com.vti.request.OrderRequest;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IAccountRepository accountRepo;
	
	@Autowired
	private ICartRepository cartRepo;
	
	@Override
	public void createOrder(int accountID, OrderRequest request) {
		Account account = accountRepo.getById(accountID);		
		Order order = new Order(request.getQuantity(), request.getTotalPrice(), 
				request.getCity(), request.getDistrict(), request.getStreet(), request.getWard(), account);
		orderRepo.save(order);
	}

}
