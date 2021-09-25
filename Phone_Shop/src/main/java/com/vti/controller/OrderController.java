package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Order;
import com.vti.service.IAccountService;
import com.vti.service.IOrderDetailService;
import com.vti.service.IOrderService;

@RestController
@RequestMapping(value = "api/v5/orders")
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	IOrderService repo;
	
	@Autowired
	IOrderDetailService Orepo;
	
	@Autowired
	IAccountService Urepo;
	
	@GetMapping()
	public ResponseEntity<List<Order>> getAll() {
		return ResponseEntity.ok(repo.findAllOrderDesc());
	}
	
	@GetMapping("/wait")
	public ResponseEntity<List<Order>> getAllWait() {
		return ResponseEntity.ok(repo.findAllOrderWait());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Order> getOne(@PathVariable("id") Long id) {
		if(!repo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repo.findById(id).get());
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<List<Order>> getAllByUser(@PathVariable("id") Long id) {
		if(!Urepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repo.findAllOrderByUserId(id));
	}
	//Modelmap
	
	@GetMapping("/account/wait/{id}")
	public ResponseEntity<List<Order>> getAllWaitByUser(@PathVariable("id") Long id) {
		if(!Urepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repo.findAllOrderWaitByUserId(id));
	}
	
	@GetMapping("/account/confirmed/{id}")
	public ResponseEntity<List<Order>> getAllConfirmedByUser(@PathVariable("id") Long id) {
		if(!Urepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repo.findAllOrderConfirmedByUserId(id));
	}
	
	@GetMapping("/account/paid/{id}")
	public ResponseEntity<List<Order>> getAllPaidByUser(@PathVariable("id") Long id) {
		if(!Urepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repo.findAllOrderPaidByUserId(id));
	}
	
	@GetMapping("/account/cancel/{id}")
	public ResponseEntity<List<Order>> getAllCancelByUser(@PathVariable("id") Long id) {
		if(!Urepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repo.findAllOrderCancelByUserId(id));
	}
	
	@PostMapping
	public ResponseEntity<Order> post(@RequestBody Order order) {
		if(repo.existsById(order.getId())) {
			return ResponseEntity.badRequest().build();
		}
		if(!Urepo.existsById(order.getAccount().getId())) {
			return ResponseEntity.notFound().build();
		}
		Order o = repo.save(order);
		return ResponseEntity.ok(o);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Order> put(@PathVariable("id") Long id, @RequestBody Order order) {
		if(!repo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		if(id != order.getId()) {
			return ResponseEntity.badRequest().build();
		}
		Order o = repo.save(order);
		return ResponseEntity.ok(o);
	}
	
}
