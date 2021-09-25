package com.vti.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{

	@Query("SELECT p FROM Product p ORDER BY p.price DESC")
	public Page<Product> findAllOrderByPriceDesc(Pageable pageable);
	
	@Query("SELECT p FROM Product p ORDER BY p.price ASC")
	public Page<Product> findAllOrderByPriceAsc(Pageable pageable);
	
	@Query(value = "SELECT * FROM products WHERE category_id = ?", nativeQuery = true)
	List<Product> findAllProductByCategoryId(Long id);
	
	@Query(value = "SELECT * FROM products WHERE product_id = ?", nativeQuery = true)
	Product findByProductId(Long id);
	
	@Query(value = "SELECT * FROM products", nativeQuery = true)
	List<Product> findAllProduct();
}
