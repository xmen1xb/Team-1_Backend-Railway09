package com.vti.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.vti.validation.CheckEmailNotExists;
import com.vti.validation.EmailValidator;
import com.vti.validation.UsernameValidator;

public class AccountRequest {
	
	@NotBlank(message = "Username không được để trống")
	@UsernameValidator
	private String username;

	@NotBlank(message = "Fullname không được để trống")
	@Length(min = 6, max = 50, message = "Độ dài FullName không hợp lệ")
	private String fullname;
	
	@NotBlank(message = "Email không được để trống")
	@CheckEmailNotExists(message = "Email này đã có trên hệ thống, hãy lựa chọn Email khác!!")
	@EmailValidator
	private String email;
	
	private String phoneNumber;
	
	private String address;
	
	@NotBlank(message = "Password không được để trống")
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password có ít nhất 8 kí tự, Có ít nhất 1 kí tự thường, 1 kí tự viết hoa và 1 chữ số, \"\r\n"
			+ "	+ \"Có 1 trong các kí tự đặc biệt sau (! # $ @ _ + , ? . - )")
	private String password;
	
	public AccountRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phoneNumber;
	}

	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
