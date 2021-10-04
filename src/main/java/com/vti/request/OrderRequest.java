package com.vti.request;

public class OrderRequest {

	private String description;
	private String fullname;
	private short quantity;
	private Double totalPrice;
	private String address;
	private String phone;
	
	public OrderRequest() {
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(short quantity, Double totalPrice,String fullname, String address, String phone) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
