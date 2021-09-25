package com.vti.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.dto.UserForm;
import com.vti.dto.UserFormForRegistration;
import com.vti.entity.Account;
import com.vti.entity.RegistationAccountToken;
import com.vti.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IRegistrationUserTokenRepository;

@Service
public class AccountService implements IAccountService{

	@Autowired
	IAccountRepository userRepository;
	

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private IRegistrationUserTokenRepository registrationUserTokenRepository;
	
//	Dùng để mã hóa Password
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean exist(String email){
	       return userRepository.existsByEmail(email);
	    }

	@Override
	public Account findById(Long id) {
		return userRepository.findByIdAndStatus(id);
	}

	@Override
	public Account findByEmail(short status, String email) {
		return userRepository.findByEmail(status, email);	
	}

	@Override
	public void delete(Long id) {
		Account user = userRepository.getById(id);
		userRepository.delete(user);	
	}

	@Override
	public List<Account> showAll() {
		return userRepository.findAllByStatus();
	}

	@Override
	@Transactional
	public void add(Account user) {
		userRepository.save(user);
	}
	
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account user = userRepository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole().toString()));
	}	
	

	@Override
	public void createUserRegister(UserFormForRegistration form) {
			
//			boolean exist = this.exist(form.getEmail());
//			if(exist) {
//				return;
//			}
			Account user = new Account();
			user.setEmail(form.getEmail());
			user.setUsername(form.getUserName());
			user.setFullname(form.getName());
			user.setAddress(form.getAddress());
			user.setPhone(form.getPhone());
			user.setImage(form.getImage());
			user.setPassword(passwordEncoder.encode(form.getPassword()));
			userRepository.save(user);
			// create new user registration token
			createNewRegistrationUserToken(user);
			// send email to confirm
			sendConfirmUserRegistrationViaEmail(user.getEmail());
		
	}
	private void createNewRegistrationUserToken(Account user) {
		System.out.println(user);
		// create new token for confirm Registration
		final String newToken = UUID.randomUUID().toString();
		RegistationAccountToken token = new RegistationAccountToken(newToken, user);

		registrationUserTokenRepository.save(token);
	}

//Gui mail xac nhan
	private void sendConfirmUserRegistrationViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));
	}
	
	@Override
	public void activeUser(String token) {
		RegistationAccountToken registrationUserToken = registrationUserTokenRepository.findByToken(token);

		Account user = registrationUserToken.getAccount();
		user.setStatus((short) 1);

		userRepository.save(user);

		// remove Registration User Token
		registrationUserTokenRepository.deleteById(registrationUserToken.getId());

		
	}

	@Override
	public void createUser(UserForm userForm) {
		Account user = new Account();
		
		user.setEmail(userForm.getEmail());
		user.setUsername(userForm.getUserName());
		user.setFullname(userForm.getName());
		user.setAddress(userForm.getAddress());
		user.setPhone(userForm.getPhone());
		user.setImage(userForm.getImage());
		
		userRepository.save(user);
		
	}
}
