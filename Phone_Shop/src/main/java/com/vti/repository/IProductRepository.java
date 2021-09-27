package com.vti.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{

	@Query(value = "SELECT p FROM Product p  ORDER BY (p.price - ((p.price * p.discount)/100)) DESC")
	public Page<Product> findAllOrderByPriceDesc(Pageable pageable);
	
	@Query("SELECT p FROM Product p  ORDER BY (p.price - ((p.price * p.discount)/100)) ASC")
	public Page<Product> findAllOrderByPriceAsc(Pageable pageable);
}
