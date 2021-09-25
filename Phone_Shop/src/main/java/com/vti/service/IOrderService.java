package com.vti.service;

import java.util.List;
import java.util.Optional;

import com.vti.entity.Order;

public interface IOrderService {

	List<Order> findAllOrderDesc();
	
	List<Order> findAllOrderByUserId(Long id);
	
	List<Order> findAllOrderWait();
	
	List<Order> findAllOrderCancelByUserId(Long id);
	
	List<Order> findAllOrderWaitByUserId(Long id);
	
	List<Order> findAllOrderConfirmedByUserId(Long id);
	
	List<Order> findAllOrderPaidByUserId(Long id);

	boolean existsById(Long id);

	Optional<Order> findById(Long id);

	Order save(Order entity);
}
