package com.vti.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordCorrectValidator implements ConstraintValidator<PasswordValidator, String>{

	private Pattern pattern; 
	private static final String PASSWORD_PATTERN = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"; 													
	
	public PasswordCorrectValidator() {
		pattern = Pattern.compile(PASSWORD_PATTERN); 
	}
	
	@Override
	public void initialize(PasswordValidator constraintAnnotation) {

		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {

		return pattern.matcher(password).matches(); 
	}

}
