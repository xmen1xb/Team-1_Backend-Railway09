package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Memory;

@Repository
public interface IProductMemoryRepository extends JpaRepository<Memory, Long>{

}
