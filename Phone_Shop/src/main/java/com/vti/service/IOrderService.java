package com.vti.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import com.vti.entity.Order;
import com.vti.request.OrderRequest;

public interface IOrderService {
	
	public Page<Order> getAllOrder(Pageable pageable);
	
	public Page<Order> getAllOrderByAccountId(int accountID, Pageable pageable);

	public void createOrder(int accountID, OrderRequest request);
	
	public void updateOrder(int orderID);
	
	public void endOrder(int orderID);
	
	public void deleteOrder(int orderID);
	
	public void sendConfirmOrderViaEmail(String email);
	
	public void sendConfirmEndOrderViaEmail(String email);
}
