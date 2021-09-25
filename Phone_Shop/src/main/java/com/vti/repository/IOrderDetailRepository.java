package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.OrderDetail;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	@Query(value = "select * from order_details where order_id = ?", nativeQuery = true)
	List<OrderDetail> findOrderDetailByOrderId(Long id);
}
