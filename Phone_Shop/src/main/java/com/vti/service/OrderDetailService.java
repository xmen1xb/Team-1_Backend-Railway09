package com.vti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.OrderDetail;
import com.vti.repository.IOrderDetailRepository;

@Service
public class OrderDetailService implements IOrderDetailService{

	@Autowired
	IOrderDetailRepository ods;
	
	@Override
	public List<OrderDetail> findOrderDetailByOrderId(Long id) {
		return ods.findOrderDetailByOrderId(id);
	}

	@Override
	public OrderDetail save(OrderDetail entity) {
		return ods.save(entity);
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return ods.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return ods.existsById(id);
	}

}
