/**
 * Represents a LoginRequest
 *
 * @author P Tr Xuan
 * Created on Sep 14, 2021
 */
package com.vti.request;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class LoginRequest {
	@NotBlank
	@Length(min = 5, max = 50)
	private String username;
	@NotBlank
	@Length(min = 6, max = 50)
	private String password;
	
	public LoginRequest() {
		// TODO Auto-generated constructor stub
	}

	public LoginRequest(@NotBlank @Length(min = 5, max = 50) String username,
			@NotBlank @Length(min = 6, max = 50) String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
