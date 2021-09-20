package com.vti.response;

import java.util.Date;

public class ProductResponse {

	private int id;
	private String name;
	private String description;
	private Double price;
	private String ramname;
	private String memoryname;
	private String brandname;
	private String category;
	private short quantity;
	private String image;
	private Date enter_date;
	
	public ProductResponse() {
		// TODO Auto-generated constructor stub
	}

	public ProductResponse(int id, String name, String description, Double price, String ram, String memory,
			String brand, String category, short quantity, String image, Date enter_date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.ramname = ram;
		this.memoryname = memory;
		this.brandname = brand;
		this.category = category;
		this.quantity = quantity;
		this.image = image;
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
		return ramname;
	}

	public void setRam(String ram) {
		this.ramname = ram;
	}

	public String getMemory() {
		return memoryname;
	}

	public void setMemory(String memory) {
		this.memoryname = memory;
	}

	public String getBrand() {
		return brandname;
	}

	public void setBrand(String brand) {
		this.brandname = brand;
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

}
