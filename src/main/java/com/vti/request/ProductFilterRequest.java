package com.vti.request;

public class ProductFilterRequest {

	private String ramName;
	private String brandName;
	private String memoryName;
	
	public ProductFilterRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getRamName() {
		return ramName;
	}

	public void setRamName(String ramName) {
		this.ramName = ramName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String bandName) {
		this.brandName = bandName;
	}

	public String getMemoryName() {
		return memoryName;
	}

	public void setMemoryName(String memoryName) {
		this.memoryName = memoryName;
	}
}
