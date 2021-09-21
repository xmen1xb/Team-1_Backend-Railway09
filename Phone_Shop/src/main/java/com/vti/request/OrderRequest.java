package com.vti.request;

public class OrderRequest {

	private short quantity;
	private Double totalPrice;
	private String city;
	private String district;	
	private String ward;	
	private String street;
	
	public OrderRequest() {
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(short quantity, Double totalPrice, String city, String district, String ward, String street) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.city = city;
		this.district = district;
		this.ward = ward;
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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
}
