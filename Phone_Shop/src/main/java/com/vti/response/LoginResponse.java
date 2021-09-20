/**
 * Represents a LoginResponse
 *
 * @author P Tr Xuan
 * Created on Sep 14, 2021
 */
package com.vti.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class LoginResponse {
	
		private int accountId;

		private String email;
	
	    private String accessToken;
	    
	    @JsonProperty("expires_in")
	    private int expireTime;
	    
	    private String role;
	    
	    public LoginResponse() {
			// TODO Auto-generated constructor stub
		}

		public LoginResponse(int accountId, String email, String accessToken, int expireTime, String role) {
			super();
			this.accountId = accountId;
			this.email = email;
			this.accessToken = accessToken;
			this.expireTime = expireTime;
			this.role = role;
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

		public int getAccountId() {
			return accountId;
		}
}
