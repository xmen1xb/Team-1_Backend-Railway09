package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.RegistationAccountToken;

@Repository
public interface IRegistrationUserTokenRepository extends JpaRepository<RegistationAccountToken, Long>{

	public RegistationAccountToken findByToken(String token);
	
	public boolean existsByToken(String token);
	
	@Query("	SELECT 	token	"
			+ "	FROM 	RegistationAccountToken "
			+ " WHERE 	user_id = :accountID")
	public String findByUserId(Long accountID);

	@Transactional
	@Modifying
	@Query("	DELETE 							"
			+ "	FROM 	RegistationAccountToken 	"
			+ " WHERE 	user_id = :userId")
	public void deleteByUserId(Long userId);
}
