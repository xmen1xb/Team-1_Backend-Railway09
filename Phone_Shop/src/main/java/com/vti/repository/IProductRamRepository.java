package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Ram;

@Repository
public interface IProductRamRepository extends JpaRepository<Ram, Long>{

}
