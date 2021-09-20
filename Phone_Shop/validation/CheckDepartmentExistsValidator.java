package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.datalayer.DepartmentRepository;

public class CheckDepartmentExistsValidator implements ConstraintValidator<CheckDepartmentExists, Integer> {
	private DepartmentRepository depRepository;

	@Override
	public void initialize(CheckDepartmentExists constraintAnnotation) {
		depRepository = new DepartmentRepository();
	}

	@Override
	public boolean isValid(Integer depID, ConstraintValidatorContext context) {

		Boolean flag = depRepository.isDepartmentExistsByID((short) depID.intValue());
		return flag;
	}

}
