package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.request.OrderRequest;
import com.vti.service.IOrderService;

@RestController
@RequestMapping(value = "api/v5/orders")
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping(value = "/{accountId}")
	public ResponseEntity<?> createAccount(@PathVariable (name = "accountId") int accountID, @RequestBody OrderRequest request){
		orderService.createOrder(accountID, request);
		return new ResponseEntity<String>("Create successfully!!",
				HttpStatus.CREATED);
		
	}
}
