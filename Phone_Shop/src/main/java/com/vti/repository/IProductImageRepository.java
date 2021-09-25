package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Image;

@Repository
public interface IProductImageRepository extends JpaRepository<Image, Long>{
	
}
