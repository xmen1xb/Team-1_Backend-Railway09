
package com.vti.exception;

import org.springframework.validation.Errors;

import lombok.Getter;

/**
 * Represents a ValidationErrorException
 *
 * 
 * @author P Tr Xuan
 * Created on Sep 15, 2021
 */
public class ValidationErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
		@Getter
	    private Errors errors;

	    public ValidationErrorException(Errors errors) {
	        super();
	        this.errors = errors;
	    }
}
