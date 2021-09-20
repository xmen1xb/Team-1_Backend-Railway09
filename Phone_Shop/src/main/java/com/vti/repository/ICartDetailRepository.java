package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.CartDetail;

@Repository
public interface ICartDetailRepository extends JpaRepository<CartDetail, Integer>{

}
