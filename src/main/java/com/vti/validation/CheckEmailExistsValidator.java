package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.util.StringUtils;
import com.vti.repository.IAccountRepository;

public class CheckEmailExistsValidator implements ConstraintValidator<CheckEmailNotExists, String> {
	
	@Autowired
	private IAccountRepository accountRepo;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (StringUtils.isNullOrEmpty(email)) {
			return false;
		}
		Boolean flag = accountRepo.existsByEmail(email);
		return !flag;
	}

}
