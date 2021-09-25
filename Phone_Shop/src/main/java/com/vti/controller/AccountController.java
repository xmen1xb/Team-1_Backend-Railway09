package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
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
	
	@GetMapping
	public ResponseEntity<List<Account>> showAll() {
		return new ResponseEntity<>(accountService.showAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getUserById(@PathVariable("id") Long id) {
		Account u = accountService.findById(id);
		if(u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	@GetMapping("email/{email}")
	public ResponseEntity<Account> getOneByEmail(@PathVariable("email") String email) {
		Account u = accountService.findByEmail((short) 1, email);
		if(u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<?> post(@RequestBody Account user, String email) {
		Account u = accountService.findById(user.getId());
		if(u != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		if(accountService.exist(email)==true){
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		accountService.add(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> put(@PathVariable("id") int id, @RequestBody Account user) {
		if(user.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Account u = accountService.findById(user.getId());
		if(u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		accountService.add(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		Account u = accountService.findById(id);
		if(u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		accountService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
