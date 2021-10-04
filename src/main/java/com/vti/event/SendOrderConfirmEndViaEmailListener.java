package com.vti.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.vti.service.IEmailService;

@Component
public class SendOrderConfirmEndViaEmailListener 
					implements ApplicationListener<OnSendOrderConfirmEndViaEmailEvent>{

	@Autowired
	private IEmailService emailService;

	@Override
	public void onApplicationEvent(OnSendOrderConfirmEndViaEmailEvent event) {
		sendConfirmViaEmail(event.getEmail());
		
	}
	
	private void sendConfirmViaEmail(String email) {
		emailService.sendOrderConfirmEnd(email);
	}
}
