package com.vti.event;

import org.springframework.context.ApplicationEvent;

public class OnSendOrderConfirmEndViaEmailEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	private String email;
	
	public OnSendOrderConfirmEndViaEmailEvent(String email) {
		super(email);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
