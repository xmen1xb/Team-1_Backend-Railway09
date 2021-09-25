package com.vti.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailCorrectValidator implements ConstraintValidator<EmailValidator, String>{
	private Pattern pattern; 
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public EmailCorrectValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return pattern.matcher(email).matches(); 
	}

}
