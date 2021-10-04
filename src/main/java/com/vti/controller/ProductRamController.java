package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.ProductRam;
import com.vti.response.ProductRamResponse;
import com.vti.service.IProductRamService;

@RestController
@RequestMapping(value = "api/v1/productramcontrollers")
@CrossOrigin("*")
public class ProductRamController {

	@Autowired
	private IProductRamService productRamService;
	
	/**
	 * API getAll ProductRam
	 * Đổ dữ liệu vào cột filter theo ram
	 */
	
	@GetMapping
	public ResponseEntity<?> getAllProductRamd(){
		List<ProductRam> listProductRam = productRamService.getAllProductRam();
		
		List<ProductRamResponse> listResponse = new ArrayList<>();
		for (ProductRam productRam  : listProductRam) {
			ProductRamResponse productRamResponse = new ProductRamResponse(productRam.getProductRamId(), productRam.getRamName());
			listResponse.add(productRamResponse);
		}
		return new ResponseEntity<>(listResponse, HttpStatus.OK);
		
	} 
}
