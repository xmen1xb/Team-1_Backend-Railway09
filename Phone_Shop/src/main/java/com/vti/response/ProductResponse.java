package com.vti.response;

import java.util.Date;

public class ProductResponse {

	private int id;
	private String name;
	private String description;
	private short discount;
	private Double price;
	private String ram;
	private String memory;
	private String brand;
	private String category;
	private short quantity;
	private String image;
	private Date enter_date;
	
	public ProductResponse() {
		// TODO Auto-generated constructor stub
	}

	public ProductResponse(int id, String name, String description, Double price, String ram, String memory,
			String brand, String category, short quantity, String image,short discount, Date enter_date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.ram = ram;
		this.memory = memory;
		this.brand = brand;
		this.category = category;
		this.quantity = quantity;
		this.image = image;
		this.discount = discount;
		this.enter_date = enter_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getEnter_date() {
		return enter_date;
	}

	public void setEnter_date(Date enter_date) {
		this.enter_date = enter_date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public short getDiscount() {
		return discount;
	}

	public void setDiscount(short discount) {
		this.discount = discount;
	}

}
