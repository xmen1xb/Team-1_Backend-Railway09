package com.vti.service;

import com.vti.request.OrderRequest;

public interface IOrderService {

	public void createOrder(int accountID, OrderRequest request);
}
