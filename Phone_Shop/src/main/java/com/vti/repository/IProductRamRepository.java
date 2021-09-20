package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.ProductRam;

@Repository
public interface IProductRamRepository extends JpaRepository<ProductRam, Short>{

}
