package com.vti.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Product;
import com.vti.request.ProductFilterRequest;
import com.vti.response.ProductResponse;
import com.vti.service.IProductService;


@RestController
@RequestMapping(value = "api/v2/products")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping()
	public ResponseEntity<?> getAllProducts(Pageable pageable, @RequestParam(required = false) String search,
			ProductFilterRequest filter) {
		Page<Product> entities = productService.getAllProducts(pageable, search, filter);

		Page<ProductResponse> pageResponse = entities.map(new Function<Product, ProductResponse>() {

			@Override
			public ProductResponse apply(Product product) {
				ProductResponse response = new ProductResponse(product.getProduct_id(), product.getProduct_name(),
						product.getDescription(), product.getPrice(), product.getRam().getRamName(), product.getMemory().getMemoryName(),
						product.getBrand().getBrandName(), product.getCategory(), product.getQuantity(),
						product.getPathImage(),product.getEnter_date());
				return response;
			}
		});
		return new ResponseEntity<>(pageResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getProductByID(@PathVariable(name = "id") short id){
		Product product = productService.getProductById(id);
		
		ProductResponse response = new ProductResponse(product.getProduct_id(), product.getProduct_name(),
				product.getDescription(), product.getPrice(), product.getRam().getRamName(), product.getMemory().getMemoryName(),
				product.getBrand().getBrandName(), product.getCategory(), product.getQuantity(),
				product.getPathImage(), product.getEnter_date());
		
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id) {
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
