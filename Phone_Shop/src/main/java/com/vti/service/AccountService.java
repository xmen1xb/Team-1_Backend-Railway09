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
import com.vti.entity.ResetPasswordToken;
import com.vti.enumerate.AccountStatus;
import com.vti.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.event.OnSendResetPasswordConfirmViaEmailEvent;
import com.vti.exception.NotFoundException;
import com.vti.repository.IAccountRepository;
import com.vti.repository.ICartRepository;
import com.vti.repository.IRegistrationUserTokenRepository;
import com.vti.repository.IResetPasswordTokenRepository;
import com.vti.request.AccountRequest;
import com.vti.request.AccountUpdateRequest;

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
	
	@Autowired
	private IResetPasswordTokenRepository resetPasswordRepo;

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
	public void resetPassword(String email) {
		Account account = account_repo.findByEmail(email);
		
		if (account == null) {
			throw new NotFoundException("Email nhập vào chưa đúng. Xin kiểm tra lại");		
		}
		createResetPasswordToken(account);
		sendConfirmResetPasswordViaEmail(account.getEmail());
	}
	
	@Override
	public void activeResetPassword(String token) {
		ResetPasswordToken activeToken = resetPasswordRepo.findByToken(token);

		Account account = activeToken.getAccount();
		account.setPassword(passwordEncoder.encode("123456"));
		
		account_repo.save(account);
		
		resetPasswordRepo.deleteById(activeToken.getId());
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
	
	private void createResetPasswordToken(Account account) {

		// create new token for confirm ResetPassword
		final String newToken = UUID.randomUUID().toString();
		ResetPasswordToken token = new ResetPasswordToken(newToken, account);
		
		resetPasswordRepo.save(token);
	}

	@Override
	public void sendConfirmUserRegistrationViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));
		
	}
	
	@Override
	public void sendConfirmResetPasswordViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendResetPasswordConfirmViaEmailEvent(email));
		
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

	@Override
	public void updateAccount(int id, AccountUpdateRequest request) {
		Account account = account_repo.getById(id);
		
			account.setFullname(request.getFullname());
			account.setEmail(request.getEmail());	
			account.setPhonenumber(request.getPhoneNumber());
			account.setAddress(request.getAddress());
			account.setPassword(passwordEncoder.encode(request.getPassword()));
		
		account_repo.save(account);
	}
		
}
