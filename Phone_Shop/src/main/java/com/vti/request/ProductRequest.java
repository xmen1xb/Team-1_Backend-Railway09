package com.vti.request;

public class ProductRequest {

	private String name;
	private String description;
	private short discount;
	private Double price;
	private String ram;
	private String memory;
	private String brand;
	private String category;
	private short quantity;

	public ProductRequest() {
		// TODO Auto-generated constructor stub
	}

	public ProductRequest(String name, String description, short discount, Double price, String ram, String memory,
			String brand, String category, short quantity) {
		super();
		this.name = name;
		this.description = description;
		this.discount = discount;
		this.price = price;
		this.ram = ram;
		this.memory = memory;
		this.brand = brand;
		this.category = category;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getDiscount() {
		return discount;
	}

	public void setDiscount(short discount) {
		this.discount = discount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
}
