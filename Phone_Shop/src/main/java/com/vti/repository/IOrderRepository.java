package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{
	@Query(value = "select * from orders order by order_date desc", nativeQuery = true)
	List<Order> findAllOrderDesc();

	@Query(value = "select * from orders where account_id = ? order by order_date desc", nativeQuery = true)
	List<Order> findAllOrderByUserId(Long id);

	@Query(value = "select * from orders where status = 1", nativeQuery = true)
	List<Order> findAllOrderWait();

	@Query(value = "select * from orders where account_id = ? and status = 0", nativeQuery = true)
	List<Order> findAllOrderCancelByUserId(Long id);

	@Query(value = "select * from orders where account_id = ? and status = 1", nativeQuery = true)
	List<Order> findAllOrderWaitByUserId(Long id);

	@Query(value = "select * from orders where account_id = ? and status = 2", nativeQuery = true)
	List<Order> findAllOrderConfirmedByUserId(Long id);

	@Query(value = "select * from orders where account_id = ? and status = 3", nativeQuery = true)
	List<Order> findAllOrderPaidByUserId(Long id);
}
