package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.service.ICartDetailService;

@RestController
@RequestMapping(value = "api/v4/cartdetail")
@CrossOrigin("*")
public class CartDetailController {

	@Autowired
	private ICartDetailService cartdetailService;
	
	@PostMapping
	public ResponseEntity<?> createCartDetail(@RequestParam(name = "productId") int productId,@RequestParam(name = "accountId") int accountId){
		cartdetailService.createCartDetail(productId, accountId);
		return new ResponseEntity<String>("Create successfully!!",
				HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCartDetail(@PathVariable(name = "id") int id) {
		cartdetailService.deleteCartDetail(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateCartDetailUp(@PathVariable(name = "id") int id) {
		cartdetailService.updateCartDetailUp(id);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);

		
	}
	
	@PutMapping()
	public ResponseEntity<?> updateCartDetailDown(@RequestParam(name = "id") int id) {
		cartdetailService.updateCartDetailDown(id);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
		
	}
}
