/**
 * Represents a LoginUserDetailService
 *
 * @author P Tr Xuan
 * Created on Sep 14, 2021
 */
package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import com.vti.repository.LoginUserDetail;

@Component
public class LoginUserDetailService implements UserDetailsService{
	
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = accountRepository.findByUsername(username);
		
		if (account == null) {
			throw new UsernameNotFoundException(username + " is not found.");
		} 
		
		return LoginUserDetail.create(account);
	}

}
