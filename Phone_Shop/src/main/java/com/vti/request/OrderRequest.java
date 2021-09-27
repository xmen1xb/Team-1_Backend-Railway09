package com.vti.request;

public class OrderRequest {

	private short quantity;
	private Double totalPrice;
	private String address;
	
	public OrderRequest() {
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(short quantity, Double totalPrice, String address) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.address = address;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
