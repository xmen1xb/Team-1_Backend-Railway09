package com.vti.enumerate;

public enum OrderStatusEnum {
	Active("Active"), Not_Active("Not_Active"), End("End"), Delete("Delete");
	
	private String value;
	
	private OrderStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static OrderStatusEnum of(String value) {
		
		for (OrderStatusEnum name : OrderStatusEnum.values()) {
			if (name.getValue().equals(value)) {
				return name;
			}
		}
		return null;
	}
}
