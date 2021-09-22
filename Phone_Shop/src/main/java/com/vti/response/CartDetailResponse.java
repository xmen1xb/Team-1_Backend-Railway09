package com.vti.response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.vti.enumerate.CartDetailStatus;

public class CartDetailResponse {

	private int id;
	private Double price;
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	private CartDetailStatus status = CartDetailStatus.Not_Order;
	
	private ProductResponse product;
	
	public CartDetailResponse() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductResponse getProduct() {
		return product;
	}

	public void setProduct(ProductResponse product) {
		this.product = product;
	}

	public CartDetailStatus getStatus() {
		return status;
	}

	public void setStatus(CartDetailStatus status) {
		this.status = status;
	}
}
