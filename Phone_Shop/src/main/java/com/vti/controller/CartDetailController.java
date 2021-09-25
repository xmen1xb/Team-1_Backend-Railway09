package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.CartDetail;
import com.vti.entity.Product;
import com.vti.service.ICartDetailService;
import com.vti.service.ICartService;
import com.vti.service.IProductService;

@RestController
@RequestMapping(value = "api/v4/cartdetail")
@CrossOrigin("*")
public class CartDetailController {

	@Autowired
	ICartService cartService;

	@Autowired
	ICartDetailService cartDetailService;
	
	@Autowired
	IProductService productService;

	@GetMapping("/cart/{id}")
	public ResponseEntity<List<CartDetail>> getByCartId(@PathVariable("id") Long id) {
		if (!cartService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cartDetailService.getByCartId(id));
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<CartDetail> getOne(@PathVariable("id") Long id) {
		if(!cartDetailService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cartDetailService.findById(id).get());
	}

	@PostMapping()
	public ResponseEntity<CartDetail> post(@RequestBody CartDetail cartDetail ) {
		if (!cartService.existsById(cartDetail.getCart().getId())) {
			return ResponseEntity.notFound().build();
		}
	
		boolean check = false;
		// lấy những sản phẩm trong db 
		List<Product> listP = productService.showAll();
		// lấy ra sản phẩm  mình truyền vào 
		Product product = productService.getById(cartDetail.getProduct().getId());
		for(Product p : listP){
			// sản phẩm có được kích hoạt trong db không 
			if(p.getId() == product.getId()) {
				check = true;
			}
		};
		if(!check) {
			return ResponseEntity.notFound().build();			
		}
		
		// lấy ra tất cả cartdetail  của mình truyền vào ban đầu  theo   id của cart 
		List<CartDetail> listD = cartDetailService.getByCartId(cartDetail.getCart().getId());
		for (CartDetail item : listD) {
			if (item.getProduct().getId() == cartDetail.getProduct().getId()) {
				item.setQuantity(item.getQuantity() + 1);
				item.setPrice(item.getPrice() + cartDetail.getPrice());
				return ResponseEntity.ok(cartDetailService.save(item));
			}
		}
		return ResponseEntity.ok(cartDetailService.save(cartDetail));
	}

	@PutMapping()
	// thêm cartdetail mới thay cho cartdetail cũ
	public ResponseEntity<CartDetail> put(@RequestBody CartDetail cartDetail) {
		if (!cartService.existsById(cartDetail.getCart().getId())) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cartDetailService.save(cartDetail));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		if (!cartDetailService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cartDetailService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
