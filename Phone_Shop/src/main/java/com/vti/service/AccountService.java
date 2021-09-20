package com.vti.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Cart;
import com.vti.entity.RegistationAccountToken;
import com.vti.enumerate.AccountStatus;
import com.vti.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.repository.IAccountRepository;
import com.vti.repository.ICartRepository;
import com.vti.repository.IRegistrationUserTokenRepository;
import com.vti.request.AccountRequest;

@Service
public class AccountService implements IAccountService{

	@Autowired
	private IAccountRepository account_repo;
	
	@Autowired
	private IRegistrationUserTokenRepository token_repo;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ICartRepository cartRepo;

	@Override
	public Page<Account> getAllAccounts(Pageable pageable) {
		
		return account_repo.findAll(pageable);
	}

	@Override
	public Account getAccountById(int id) {
	
		return account_repo.findById(id).get();
	}

	@Override
	public Account getAccountByUsername(String name) {
		
		return account_repo.findByUsername(name);
	}
	
	@Override
	public Account getAccountByEmail(String email) {
		
		return account_repo.findByEmail(email);
	}

	@Override
	public void createAccount(AccountRequest request) {
		Account account = new Account(request.getUsername(), request.getFullname(), request.getEmail(),
				 passwordEncoder.encode(request.getPassword()));
		
		account_repo.save(account);
		
		createNewRegistrationUserToken(account);
		
		sendConfirmUserRegistrationViaEmail(account.getEmail());
		
		createCart(account);
	}

	@Override
	public void activeUser(String token) {
		RegistationAccountToken active_token = token_repo.findByToken(token);
		
		Account account = active_token.getAccount();
		account.setStatus(AccountStatus.Active);
		
		account_repo.save(account);
		
		token_repo.deleteById(active_token.getId());
	}
	
	private void createNewRegistrationUserToken(Account account) {

		// create new token for confirm Registration
		final String newToken = UUID.randomUUID().toString();
		RegistationAccountToken token = new RegistationAccountToken(newToken, account);

		token_repo.save(token);
	}

	@Override
	public void sendConfirmUserRegistrationViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));
		
	}

	@Override
	public boolean existsByUsername(String name) {
		
		return account_repo.existsByUsername(name);
	}

	@Override
	public boolean existsByEmail(String email) {
		
		return account_repo.existsByEmail(email);
	}

	@Override
	public boolean existsByPhoneNumber(String phoneNumber) {
		
		return account_repo.existsByPhonenumber(phoneNumber);
	}

	@Override
	public void createCart(Account account) {
		Cart cart = new Cart();
		cart.setQuantity(0);
		cart.setTotal_price(0.0);
		cart.setAccount(account);
		cartRepo.save(cart);	
	}

	@Override
	public void deleteAccount(int id) {
		account_repo.deleteById(id);
		
	}
}
