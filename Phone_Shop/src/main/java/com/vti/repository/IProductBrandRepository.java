package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.ProductBrand;

@Repository
public interface IProductBrandRepository extends JpaRepository<ProductBrand, Short>{

}
