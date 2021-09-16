package com.vti.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vti.entity.Account;
import com.vti.request.AccountRequest;
import com.vti.response.AccountResponse;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@GetMapping
	public ResponseEntity<?> getAllAccounts(Pageable pageable) {
		Page<Account> entity = accountService.getAllAccounts(pageable);
		
		Page<AccountResponse> pageResponse = entity.map(new Function<Account, AccountResponse>() {

			@Override
			public AccountResponse apply(Account account) {
				AccountResponse response = new AccountResponse(account.getAccountId(), account.getUsername(), account.getFullname(), 
						account.getEmail(), account.getGender(), account.getPhone_number(), account.getAddress(), account.getRegister_date());
				return response;
			}
		});
		
		return new ResponseEntity<>(pageResponse, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") int id){
		Account account = accountService.getAccountById(id);
		
		AccountResponse response = new AccountResponse(account.getAccountId(), account.getUsername(), account.getFullname(), 
				account.getEmail(), account.getGender(), account.getPhone_number(), account.getAddress(), account.getRegister_date());
		return new ResponseEntity<AccountResponse>(response, HttpStatus.OK);			
	}
	
//	@GetMapping(value = "/{name}")
//	public ResponseEntity<?> getAccountByUserName(@PathVariable(name = "name") String username){
//		Account account = accountService.getAccountByUsername(username);
//		
//		AccountResponse response = new AccountResponse(account.getAccountId(), account.getUsername(), account.getFullname(), 
//				account.getEmail(), account.getGender(), account.getPhone_number(), account.getAddress(), account.getRegister_date());
//		return new ResponseEntity<AccountResponse>(response, HttpStatus.OK);			
//	}
	
	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountRequest request) {
		accountService.createAccount(request);
		return new ResponseEntity<String>("We have sent 1 email. Please check email to active account!",
				HttpStatus.CREATED);
	}
	
	@GetMapping("/activeUser")
	public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) {

		// active user
		accountService.activeUser(token);

		return new ResponseEntity<>("Active success!", HttpStatus.OK);
	}
	
	@GetMapping("/userRegistrationConfirmRequest")
	// validate: email exists, email not active
	public ResponseEntity<?> sendConfirmRegistrationViaEmail(@RequestParam String email) {

		accountService.sendConfirmUserRegistrationViaEmail(email);

		return new ResponseEntity<>("We have sent 1 email. Please check email to active account!", HttpStatus.OK);
	}
}
