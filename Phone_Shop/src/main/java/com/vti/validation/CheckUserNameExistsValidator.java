package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.repository.IAccountRepository;

public class CheckUserNameExistsValidator implements ConstraintValidator<CheckUserNameExists, String> {
	
	@Autowired
	private IAccountRepository account_repo;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {

		Boolean flag = account_repo.existsByUsername(username);
		return flag;
	}

}
