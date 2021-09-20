package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{

}
