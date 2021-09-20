package com.vti.response;

public class ProductMemoryResponse {

	private int productMemoryId;
	private String memoryName;
	
	public ProductMemoryResponse() {
		// TODO Auto-generated constructor stub
	}

	public ProductMemoryResponse(int productMemoryId, String memoryName) {
		super();
		this.productMemoryId = productMemoryId;
		this.memoryName = memoryName;
	}

	public int getProductMemoryId() {
		return productMemoryId;
	}

	public void setProductMemoryId(short productMemoryId) {
		this.productMemoryId = productMemoryId;
	}

	public String getMemoryName() {
		return memoryName;
	}

	public void setMemoryName(String memoryName) {
		this.memoryName = memoryName;
	}
}
