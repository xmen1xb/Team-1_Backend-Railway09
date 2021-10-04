package com.vti.request;

public class CartDetailRequest {

	private Double price;
	private short quantity = 1;
	
	public CartDetailRequest() {
		// TODO Auto-generated constructor stub
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
}
