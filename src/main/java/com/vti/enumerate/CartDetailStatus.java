package com.vti.enumerate;

public enum CartDetailStatus {
	Order("Order"), Not_Order("Not_Order");
	
	private String value;


	private CartDetailStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static CartDetailStatus of(String value) {
		for (CartDetailStatus status : CartDetailStatus.values()) {
			if (status.getValue().equals(value)) {
				return status;
			}
		}
		return null;
	}
}
