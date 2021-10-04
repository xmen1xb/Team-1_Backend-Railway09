package com.vti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.CartDetail;
import com.vti.enumerate.CartDetailStatus;

@Repository
public interface ICartDetailRepository extends JpaRepository<CartDetail, Integer>{

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM CartDetail WHERE status = :status  AND cart_id = :cartID" )
	public void deleteCartDetailbyCartAndStatus(CartDetailStatus status, int  cartID);
}
