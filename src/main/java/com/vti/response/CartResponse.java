package com.vti.response;

public class CartResponse {

	private int quantity;
	private Double totalPrice;
	
	public CartResponse() {
		// TODO Auto-generated constructor stub
	}

	public CartResponse(int quantity, Double totalPrice) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
