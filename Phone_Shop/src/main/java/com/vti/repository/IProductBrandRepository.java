package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Brand;

@Repository
public interface IProductBrandRepository extends JpaRepository<Brand, Long>{
	@Query(value = "Select * from categories where category_name = ?", nativeQuery = true)
	Brand findByName(String name);
	
	@Query(value = "Select * from categories where category_id = ?", nativeQuery = true)
	Brand findByCategoryId(Long id);
	
	@Query(value = "Select * from categories", nativeQuery = true)
	List<Brand> findAllCategory();
}
