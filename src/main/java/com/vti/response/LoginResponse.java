/**
 * Represents a LoginResponse
 *
 * @author P Tr Xuan
 * Created on Sep 14, 2021
 */
package com.vti.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

	private Integer id;

	private String email;

	private String accessToken;

	@JsonProperty("expires_in")
	private int expireTime;

	private String role;
	
	private String status;

	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(Integer id, String email, String accessToken, int expireTime, String role, String status) {
		super();
		this.id = id;
		this.email = email;
		this.accessToken = accessToken;
		this.expireTime = expireTime;
		this.role = role;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
