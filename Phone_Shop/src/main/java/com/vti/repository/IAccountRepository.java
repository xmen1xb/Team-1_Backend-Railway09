package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long>{

	@Query(value = "SELECT * FROM accounts WHERE account_id = ? and status = 1", nativeQuery = true)
	List<Account> findAllUserByUserId(Long id);
	
	@Query(value = "SELECT * FROM accounts WHERE status = 1", nativeQuery = true)
	List<Account> findAllByStatus();
	
	@Query(value = "SELECT * FROM accounts WHERE status = 1 AND account_id = ?", nativeQuery = true)
	Account findByIdAndStatus(Long id);
	
	@Query(value = "SELECT * FROM accounts WHERE status = ? AND email = ?", nativeQuery = true)
	Account findByEmail(short status, String email);

	boolean existsByEmail(String email);
	
	boolean existsByPhone(String phone);
	
	boolean existsByUsername(String username);
	
	@Query(value = "SELECT * FROM accounts WHERE status = 1 AND username = ?", nativeQuery = true)
	Account findByUserName(String username);
}
