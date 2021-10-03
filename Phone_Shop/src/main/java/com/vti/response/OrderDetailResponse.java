package com.vti.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailResponse {

	private int id;
	private Double price;
	private short quantity;
	
	private ProductResponse product;
}
