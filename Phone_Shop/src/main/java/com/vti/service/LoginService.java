/**
 * Represents a LoginService
 *
 * @author P Tr Xuan
 * Created on Sep 14, 2021
 */
package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.vti.repository.LoginUserDetail;
import com.vti.request.LoginRequest;
import com.vti.response.LoginResponse;
import com.vti.ultis.JWTTokenHelper;

@Service
public class LoginService {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JWTTokenHelper jwttokenHelper;

	@Value("${jwt.expires_in}")
	private int EXPIRES_IN;

	public LoginResponse login(LoginRequest form) {
		Authentication authentication = null;

		// Perform verification with userId and password
		Authentication request = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());

		authentication = authManager.authenticate(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Store authenticated user information
		LoginUserDetail principal = (LoginUserDetail) authentication.getPrincipal();
		
		int id = principal.getId();

		String email = principal.getEmail();

		String jwt = jwttokenHelper.generateToken(String.valueOf(principal.getId()));

		String role = principal.getRole();

		return new LoginResponse(id, email, jwt, EXPIRES_IN, role);
	}
}
