package com.vti.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Product;
import com.vti.entity.ProductImage;
import com.vti.exception.NotFoundException;
import com.vti.repository.IProductRepository;
import com.vti.request.ProductFilterRequest;
import com.vti.response.ProductImagesRespone;
import com.vti.response.ProductResponse;
import com.vti.service.IProductService;


@RestController
@RequestMapping(value = "api/v2/products")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private IProductService productService;
	
	/**
	 * API getAll Product
	 * Search theo ProductName
	 * Filter theo brand - memory - ram
	 */
	
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
	
	/**
	 * API getAll Product
	 * Filter theo price down
	 */
	
	@RequestMapping(value = "/desc", method = RequestMethod.GET)
	public ResponseEntity<?> findAllOrderByPriceDesc(Pageable pageable) {
		Page<Product> entities = productService.findAllOrderByPriceDesc(pageable);

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
	
	/**
	 * API getAll Product
	 * Filter theo price up
	 */
	
	@RequestMapping(value = "/asc", method = RequestMethod.GET)
	public ResponseEntity<?> findAllOrderByPriceAsc(Pageable pageable) {
		Page<Product> entities = productService.findAllOrderByPriceAsc(pageable);

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
	
	/**
	 * API getProduct by ProductID
	 */
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getProductByID(@PathVariable(name = "id") short id){
		Product product = productService.getProductById(id);
		
		ProductResponse response = new ProductResponse(product.getProduct_id(), product.getProduct_name(),
				product.getDescription(), product.getPrice(), product.getRam().getRamName(), product.getMemory().getMemoryName(),
				product.getBrand().getBrandName(), product.getCategory(), product.getQuantity(),
				product.getPathImage(), product.getEnter_date());
		
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);	
	}
	
	/**
	 * API deleteProduct by ProductID
	 */
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id) {
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	
	/**
	 * API lấy listProductImage by ProductID
	 */
	
	@GetMapping(value = "/{id}/images")
	public ResponseEntity<?> ProductImgesDetail(@PathVariable(name = "id") Integer productId) {
		Product product = productRepository.findById(productId).orElse(null);
		if (product == null) {
			throw new NotFoundException(String.format("Product (ID = %s) is not found", productId));
		}
		List<ProductImage> productImages = product.getListProductImage();
		List<ProductImagesRespone> listRespone = new ArrayList<>();
		for (ProductImage productImage : productImages) {
			String pathRespone =  productImage.getPath_image();
			ProductImagesRespone respone = new ProductImagesRespone(productImage.getImage_id(), productImage.getProduct().getProduct_id(), pathRespone);
			listRespone.add(respone);
		}
		return new ResponseEntity<>(listRespone, HttpStatus.OK);
	}
	
	
	
}
