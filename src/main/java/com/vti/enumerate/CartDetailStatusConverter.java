package com.vti.enumerate;

import javax.persistence.AttributeConverter;

public class CartDetailStatusConverter implements AttributeConverter<CartDetailStatus, String>{

	@Override
	public String convertToDatabaseColumn(CartDetailStatus name) {
		if (name == null) {
			return null;
		}
		return name.getValue();
	}
	

	@Override
	public CartDetailStatus convertToEntityAttribute(String value) {
	
		return CartDetailStatus.of(value);
	}

}
