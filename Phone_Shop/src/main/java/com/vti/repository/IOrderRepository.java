package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{

}
