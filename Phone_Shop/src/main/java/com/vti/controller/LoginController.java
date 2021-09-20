/**
 * Represents a LoginController
 *
 * @author P Tr Xuan
 * Created on Sep 15, 2021
 */
package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.exception.ValidationErrorException;
import com.vti.request.LoginRequest;
import com.vti.response.ErrorResponse;
import com.vti.response.LoginResponse;
import com.vti.service.LoginService;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class LoginController {

	@Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody @Validated LoginRequest loginRequest, Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationErrorException(errors);
        }
        try {
            LoginResponse loginResponse = loginService.login(loginRequest);
            return ResponseEntity.ok().body(loginResponse);

        } catch (AuthenticationException e) {
            ErrorResponse error = new ErrorResponse();
            error.setMessage("Login Failure");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }

    }
}
