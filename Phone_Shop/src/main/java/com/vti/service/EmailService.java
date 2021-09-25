package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.vti.entity.Account;
import com.vti.repository.IRegistrationUserTokenRepository;

@Component
public class EmailService implements IEmailService {

	@Autowired
	private AccountService userService;

	@Autowired
	private IRegistrationUserTokenRepository registrationUserTokenRepository;
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendRegistrationUserConfirm(String email) {

		Account user = userService.findByEmail((short) 0, email);

		String token = registrationUserTokenRepository.findByUserId(user.getId());

		String confirmationUrl = "http://localhost:8989/api/userRegister/activeUser?token=" + token;

		String subject = "Xác Nhận Đăng Ký Account";
		String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n"
				+ confirmationUrl;

		sendEmail(email, subject, content);
		
	}
	private void sendEmail(final String recipientEmail, final String subject, final String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject(subject);
		message.setText(content);

		mailSender.send(message);
	}
}
