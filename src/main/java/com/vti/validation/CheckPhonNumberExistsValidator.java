package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.util.StringUtils;
import com.vti.repository.IAccountRepository;

public class CheckPhonNumberExistsValidator implements ConstraintValidator<CheckPhonNumberExists, String>{
	
	@Autowired
	private IAccountRepository accountRepo;

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		if (StringUtils.isNullOrEmpty(phoneNumber)) {
			return false;
		}
		Boolean flag = accountRepo.existsByPhonenumber(phoneNumber);
		return !flag;
	}

}
