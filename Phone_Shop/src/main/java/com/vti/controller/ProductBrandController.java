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

import com.vti.entity.Brand;
import com.vti.service.IProductBrandService;
import com.vti.service.IProductService;

@RestController
@RequestMapping(value = "api/v1/productbrandcontrollers")
@CrossOrigin("*")
public class ProductBrandController {

	@Autowired
	IProductService productService;
	
	@Autowired
	IProductBrandService brandService;
	
	@RequestMapping()
	public ResponseEntity<List<Brand>> showAll() {
		return new ResponseEntity<>(brandService.showAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> post(@RequestBody Brand brand) {
		Brand c = brandService.findByName(brand.getBrandName());
		if(c != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		brandService.add(brand);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> put(@RequestBody Brand brand, @PathVariable("id") Long id) {
		if(!id.equals(brand.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Brand c = brandService.findById(brand.getId());
		if(c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		brandService.add(brand);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		Brand c = brandService.findById(id);
		if(c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		brandService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(brandService.findById(id), HttpStatus.OK);
	}
}
