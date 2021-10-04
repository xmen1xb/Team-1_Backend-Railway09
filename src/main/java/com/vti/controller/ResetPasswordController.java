package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v3/resetpassword")
@CrossOrigin("*")
public class ResetPasswordController {

	@Autowired
	private IAccountService accountService;
	
	/**
	 * API reset password
	 * Gửi kèm 1 mail về email đăng ký
	 */
	
	@PostMapping()
	public ResponseEntity<?> resetPassword(@RequestParam String email) {
		accountService.resetPassword(email);
		return new ResponseEntity<String>("Chúng tôi đã gửi 1 thư về hòm thư của bạn. Xin hãy bấm vào đường link "
				+ "để khởi tạo lại mật khẩu mặc định!", HttpStatus.OK );
	}
	
	/**
	 * API set password về mặc định
	 */
	
	@GetMapping("/reset")
	public ResponseEntity<?> activeResetPassword(@RequestParam String token) {
		accountService.activeResetPassword(token);
		return new ResponseEntity<>("Mật khẩu đã được set về mặc định!", HttpStatus.OK);
	}
	
	@GetMapping("/resetPasswordConfirmRequest")
	// validate: email exists, email not active
	public ResponseEntity<?> sendConfirmRegistrationViaEmail(@RequestParam String email) {

		accountService.sendConfirmResetPasswordViaEmail(email);

		return new ResponseEntity<>("Chúng tôi đã gửi 1 thư về hòm thư của bạn. Xin hãy bấm vào đường link \"\r\n"
				+ "				+ \"để khởi tạo lại mật khẩu mặc định!", HttpStatus.OK);
	}
}
