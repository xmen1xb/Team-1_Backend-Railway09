package com.vti.response;

public class ProductBrandResponse {

	private int productBrandId;
	private String brandName;
	
	public ProductBrandResponse() {
		// TODO Auto-generated constructor stub
	}

	public ProductBrandResponse(int productBrandId, String brandName) {
		super();
		this.productBrandId = productBrandId;
		this.brandName = brandName;
	}

	public int getProductBrandId() {
		return productBrandId;
	}

	public void setProductBrandId(int productBrandId) {
		this.productBrandId = productBrandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
