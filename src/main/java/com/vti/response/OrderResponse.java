package com.vti.response;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.vti.enumerate.OrderStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private String description;
	private Double totalPrice;
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum status;
}
