package com.vti.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.vti.service.IResetPasswordService;

@Component
public class SendResetPasswordConfirmViaEmailListener 
		implements ApplicationListener<OnSendResetPasswordConfirmViaEmailEvent>{

	@Autowired
	private IResetPasswordService resetPasswordService;
	
	@Override
	public void onApplicationEvent(OnSendResetPasswordConfirmViaEmailEvent event) {
		sendConfirmViaEmail(event.getEmail());
		
	}

	public void sendConfirmViaEmail(String email) {
		resetPasswordService.sendResetPasswordConfirm(email);
	}
}
