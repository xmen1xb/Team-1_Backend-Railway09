package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.ProductMemory;

@Repository
public interface IProductMemoryRepository extends JpaRepository<ProductMemory, Short>{

	public ProductMemory findByMemoryName(String name);
}
