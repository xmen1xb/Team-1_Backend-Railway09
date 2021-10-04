package com.vti.response;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

	private int id;
	private String name;
	private String description;
	private Double price;
	private String ram;
	private String memory;
	private String brand;
	private String category;
	private short quantity;
	private String camera;
	private String color;
	private String screenSize;
	private String operatingSystem;
	private String chip;
	private String battery;
	private String sim;
	private String image;
	private short discount;
	private List<ProductImagesRespone> listResponse;
	private Date enter_date;
	
	public ProductResponse(int id, String name, String description, Double price, String ram, String memory,
			String brand, String category, short quantity, String camera, String color, String screenSize,
			String operatingSystem, String chip, String battery, String sim, String image, short discount,
			Date enter_date) {
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
		this.camera = camera;
		this.color = color;
		this.screenSize = screenSize;
		this.operatingSystem = operatingSystem;
		this.chip = chip;
		this.battery = battery;
		this.sim = sim;
		this.image = image;
		this.discount = discount;
		this.enter_date = enter_date;
	}

	
}
