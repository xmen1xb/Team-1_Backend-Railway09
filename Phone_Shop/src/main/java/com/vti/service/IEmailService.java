package com.vti.service;

public interface IEmailService {

	public void sendRegistrationUserConfirm(String email);
	
	public void sendOrderConfirm(String email);
	
	public void sendOrderConfirmEnd(String email);

}
