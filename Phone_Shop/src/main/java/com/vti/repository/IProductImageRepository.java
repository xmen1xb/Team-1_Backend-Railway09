package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.ProductImage;

@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Integer>{

}
