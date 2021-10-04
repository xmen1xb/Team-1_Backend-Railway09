package com.vti.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

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

}
