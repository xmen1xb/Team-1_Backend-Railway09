package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>{

	public Account findByUsername(String name);
	
	public Account findByEmail(String email);
	
	public boolean existsByUsername(String name);

	public boolean existsByEmail(String email);
	
	public boolean existsByPhonenumber(String phonNumber);
}
