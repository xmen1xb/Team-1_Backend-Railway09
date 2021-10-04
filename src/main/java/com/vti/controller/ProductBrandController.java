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

import com.vti.entity.ProductBrand;
import com.vti.response.ProductBrandResponse;
import com.vti.service.IProductBrandService;

@RestController
@RequestMapping(value = "api/v1/productbrandcontrollers")
@CrossOrigin("*")
public class ProductBrandController {

	@Autowired
	private IProductBrandService productBrandService;
	
	/**
	 * API getAll ProductBrand
	 * Đổ dữ liệu vào cột filter theo brand
	 */
	
	@GetMapping
	public ResponseEntity<?> getAllProductBrand() {
		List<ProductBrand> listProductBrand =  productBrandService.getAllProductBrand();
		
		List<ProductBrandResponse> listResponse = new ArrayList<>();
		for (ProductBrand productBrand : listProductBrand) {
			ProductBrandResponse productBrandResponse = new ProductBrandResponse(
					productBrand.getProductBrandId(), productBrand.getBrandName());
			listResponse.add(productBrandResponse);
		}
		return new ResponseEntity<>(listResponse, HttpStatus.OK);
		
	}
}
