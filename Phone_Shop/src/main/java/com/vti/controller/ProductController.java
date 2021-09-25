package com.vti.controller;

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

import com.vti.entity.Product;
import com.vti.service.IProductService;

@RestController
@RequestMapping(value = "api/v2/products")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping
	public ResponseEntity<?> showAll() {
		return new ResponseEntity<>(productService.showAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
		Product p = productService.findById(id);
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> post(@RequestBody Product product) {
		productService.add(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Product product) {
		if(!id.equals(product.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Product p = productService.findById(product.getId());
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		productService.add(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		Product p = productService.findById(id);
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/by-category/{id}")
	public ResponseEntity<?> getAllByCategory(@PathVariable("id") Long id) {
		return new ResponseEntity<>(productService.getAllByCategory(id), HttpStatus.OK);
	}
}
