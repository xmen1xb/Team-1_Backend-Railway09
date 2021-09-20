package com.vti.enumerate;

public enum AccountGenderEnum {
	Male("Male"), Female("Female"), Unknow("Unknow");
	
	private String value;
	
	private AccountGenderEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static AccountGenderEnum of(String value) {
		
		for (AccountGenderEnum name : AccountGenderEnum.values()) {
			if (name.getValue().equals(value)) {
				return name;
			}
		}
		return null;
	}
}
