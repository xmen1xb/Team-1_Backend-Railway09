package com.vti.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductImagesRespone {

	private Integer id;

	@JsonProperty("product_id")
	private Integer productId;

	private String path;

	public ProductImagesRespone(Integer id, Integer productId, String path) {
		super();
		this.id = id;
		this.productId = productId;
		this.path = path;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
