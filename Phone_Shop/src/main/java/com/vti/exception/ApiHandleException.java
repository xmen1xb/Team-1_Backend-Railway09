/**
 * Represents a ApiHandleException
 *
 * @author P Tr Xuan
 * Created on Sep 15, 2021
 */
package com.vti.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.vti.response.ErrorResponse;

@RestControllerAdvice
public class ApiHandleException extends ResponseEntityExceptionHandler{
	

    private final MessageSource messageSource;

    public ApiHandleException(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
	
	@ExceptionHandler
    public ResponseEntity<Object> handlerValidationExceptionException(ValidationErrorException ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse();
        if (ex instanceof ValidationErrorException) {

            for (FieldError error : ex.getErrors().getFieldErrors()) {
                errors.addError(error.getField(), getMessage(error, request));
            }
        }
        return super.handleExceptionInternal(ex, errors, null, HttpStatus.BAD_REQUEST, request);
    }
	
	 private String getMessage(MessageSourceResolvable resolvable, WebRequest request) {
	        return messageSource.getMessage(resolvable, request.getLocale());
	    }

}
