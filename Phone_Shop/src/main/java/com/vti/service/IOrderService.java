package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Order;
import com.vti.enumerate.OrderStatusEnum;
import com.vti.exception.CustomerException;
import com.vti.request.OrderRequest;

public interface IOrderService {
	
	public Page<Order> getAllOrder(Pageable pageable);
	
	public Page<Order> getAllOrderByStatus(OrderStatusEnum status, Pageable pageable);
	
	public Page<Order> findByUserId(int accountID, Pageable pageable);
	
	public Order getOrderByID(int orderID);

	public void createOrder(int accountID, OrderRequest request);
	
	public void updateOrder(int orderID);
	
	public void endOrder(int orderID, OrderRequest request) throws CustomerException;
	
	public void deleteOrder(int orderID);
	
	public void sendConfirmOrderViaEmail(String email);
	
	public void sendConfirmEndOrderViaEmail(String email);
}
