package com.vti.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameCorrectValidator implements ConstraintValidator<UsernameValidator, String>{
	 private Pattern pattern; 
	 private static final String USERNAME_PATTERN = "^[a-z0-9]{6,15}$";
	 
	 public UsernameCorrectValidator() {
		 pattern = Pattern.compile(USERNAME_PATTERN); 
	}
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return pattern.matcher(username).matches(); 
	}

}
