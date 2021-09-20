package com.vti.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
import com.vti.response.AccountResponse;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	/**
	 * API getAll Account
	 * Trả ra 1 list Account theo pagging
	 */
	
  @PreAuthorize("hasRole('Admin')")
	@GetMapping
	public ResponseEntity<?> getAllAccounts(Pageable pageable) {
		Page<Account> entity = accountService.getAllAccounts(pageable);

		Page<AccountResponse> pageResponse = entity.map(new Function<Account, AccountResponse>() {

			@Override
			public AccountResponse apply(Account account) {

				AccountResponse response = new AccountResponse(account.getAccountId(), account.getUsername(), account.getFullname(), 
						account.getEmail(), account.getGender(), account.getPhonenumber(), account.getAddress(), account.getRegisterDate());

				return response;
			}
		});

		return new ResponseEntity<>(pageResponse, HttpStatus.OK);
	}

	/**
	 * API getAccount by AccountID
	 */
	
  @PreAuthorize("hasAnyRole('User','Admin')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") int id) {
		Account account = accountService.getAccountById(id);

		
		AccountResponse response = new AccountResponse(account.getAccountId(), account.getUsername(), account.getFullname(), 
				account.getEmail(), account.getGender(), account.getPhonenumber(), account.getAddress(), account.getRegisterDate());
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

	@PreAuthorize("hasAnyRole('User','Admin')")
	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountRequest request) {
		accountService.createAccount(request);
		return new ResponseEntity<String>("We have sent 1 email. Please check email to active account!",
				HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyRole('User','Admin')")
	@GetMapping("/activeUser")
	public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) {

		// active user
		accountService.activeUser(token);

		return new ResponseEntity<>("Active success!", HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('User','Admin')")
	@GetMapping("/userRegistrationConfirmRequest")
	// validate: email exists, email not active
	public ResponseEntity<?> sendConfirmRegistrationViaEmail(@RequestParam String email) {

		accountService.sendConfirmUserRegistrationViaEmail(email);

		return new ResponseEntity<>("We have sent 1 email. Please check email to active account!", HttpStatus.OK);
	}
  
	/**
	 * API deleteAccount by AccountID
	 */
  @PreAuthorize("hasRole('Admin')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") int id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
