package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.ultis.ScannerUltis;

public class EmailCorrectValidator implements ConstraintValidator<EmailValidator, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean flag = false;
		while (true) {
			String email = ScannerUltis.inputString();
			if (email == null || !email.contains("@dxc.com")) {
				System.err.println("Xin nhập đúng định dạng email: ...@dxc.com");
			} else {
				flag = true;
				return flag;
			}
		}
	}

}
