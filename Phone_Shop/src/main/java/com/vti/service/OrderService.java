package com.vti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Order;
import com.vti.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService{

	@Autowired
	IOrderRepository res;
	@Override
	public List<Order> findAllOrderDesc() {
		return res.findAllOrderDesc();
	}

	@Override
	public List<Order> findAllOrderByUserId(Long id) {
		return res.findAllOrderByUserId(id);
	}

	@Override
	public List<Order> findAllOrderWait() {
		return res.findAllOrderWait();
	}

	@Override
	public List<Order> findAllOrderCancelByUserId(Long id) {
		return res.findAllOrderCancelByUserId(id);
	}

	@Override
	public List<Order> findAllOrderWaitByUserId(Long id) {
		return res.findAllOrderWaitByUserId(id);
	}

	@Override
	public List<Order> findAllOrderConfirmedByUserId(Long id) {
		return res.findAllOrderConfirmedByUserId(id);
	}

	@Override
	public List<Order> findAllOrderPaidByUserId(Long id) {
		return res.findAllOrderPaidByUserId(id);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return res.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return res.existsById(id);
	}

	@Override
	public Order save(Order entity) {
		return res.save(entity);
	}

}
