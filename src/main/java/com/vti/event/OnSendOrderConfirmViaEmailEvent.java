package com.vti.event;

import org.springframework.context.ApplicationEvent;

public class OnSendOrderConfirmViaEmailEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private String email;
	
	public OnSendOrderConfirmViaEmailEvent(String email) {
		super(email);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
