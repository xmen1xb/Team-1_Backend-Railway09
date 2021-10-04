package com.vti.request;

public class CartRequest {

	private short quantity = 0;	
	private Double totalPrice = 0.0;	
	private int accountID;
	
	public CartRequest() {
		// TODO Auto-generated constructor stub
	}

	public CartRequest(short quantity, Double totalPrice, int accountID) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.accountID = accountID;
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

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
}
