package com.vti.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.dto.UserForm;
import com.vti.dto.UserFormForRegistration;
import com.vti.entity.Account;

public interface IAccountService  extends UserDetailsService{

	public Account findById(Long i);
	
	public void createUser(UserForm userForm);

	
	public Account findByEmail(short status, String email);
	
	public void delete(Long id);
	
	public List<Account> showAll();
	
	public void add(Account account);
	
//	public User getUserByEmail(String email);

	boolean exist(String email);
	
	boolean existsById(Long id) ;

	public void createUserRegister(UserFormForRegistration form);

	public void activeUser(String token);
	
}
