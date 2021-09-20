package com.vti.response;

public class ProductRamResponse {

	private int productRamId;
	private String ramName;
	
	public ProductRamResponse() {
		// TODO Auto-generated constructor stub
	}

	public ProductRamResponse(int productRamId, String ramName) {
		super();
		this.productRamId = productRamId;
		this.ramName = ramName;
	}

	public int getProductRamId() {
		return productRamId;
	}

	public void setProductRamId(int productRamId) {
		this.productRamId = productRamId;
	}

	public String getRamName() {
		return ramName;
	}

	public void setRamName(String ramName) {
		this.ramName = ramName;
	}
}
