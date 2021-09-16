package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
