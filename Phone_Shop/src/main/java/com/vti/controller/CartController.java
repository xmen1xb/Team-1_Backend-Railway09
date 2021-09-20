package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Cart;
import com.vti.response.CartResponse;
import com.vti.service.ICartService;

@RestController
@RequestMapping(value = "api/v5/cart")
@CrossOrigin("*")
public class CartController {

	@Autowired
	private ICartService cartService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCartById(@PathVariable(name = "id") int id){
		Cart cart = cartService.getCartbyId(id);
		
		CartResponse cartResponse = new CartResponse(cart.getQuantity(), cart.getTotal_price());
		return new ResponseEntity<CartResponse>(cartResponse, HttpStatus.OK);
		
	}
}
