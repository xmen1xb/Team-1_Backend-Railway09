package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.Rate;

public interface IRateRepository extends JpaRepository<Rate, Long>{
	@Query(value = " select *from rates where product_id = ?", nativeQuery = true)
	List<Rate> findByProductId(Long id);
	
	@Query(value = " select AVG(star) from rates where product_id=?",nativeQuery = true)
	Double getAvgByProduct(Long id);
}
