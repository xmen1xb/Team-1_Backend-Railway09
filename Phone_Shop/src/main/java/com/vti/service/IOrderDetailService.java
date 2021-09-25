package com.vti.service;

import java.util.List;
import java.util.Optional;

import com.vti.entity.OrderDetail;

public interface IOrderDetailService {

	List<OrderDetail> findOrderDetailByOrderId(Long id);

	boolean existsById(Long id);

	Optional<OrderDetail> findById(Long id);

	OrderDetail save(OrderDetail entity);
}
