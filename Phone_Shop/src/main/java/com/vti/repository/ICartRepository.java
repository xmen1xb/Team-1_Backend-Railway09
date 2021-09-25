package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long>{
	@Query(value = "select * from carts where account_id  = ? ", nativeQuery = true)
	Cart getCartUser(Long id);
}
