package com.vti.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{

	@Query(value = "SELECT o FROM Order o WHERE o.userId.accountId = :accountId")
	public Page<Order> findByUserId(int accountId, Pageable pageable);
}
