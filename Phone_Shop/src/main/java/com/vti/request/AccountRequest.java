package com.vti.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.vti.validation.CheckEmailNotExists;
import com.vti.validation.CheckPhonNumberExists;
import com.vti.validation.CheckUserNameExists;
import com.vti.validation.EmailValidator;

public class AccountRequest {

	@NotBlank(message = "Không thể để trống")
	@Length(max = 12, min = 6, message = "Tên phải từ 6-12 kí tự" )
	@CheckUserNameExists
	private String username;
	
	@NotBlank(message = "Không thể để trống")
	@Length(max = 12, min = 6, message = "Tên phải từ 6-12 kí tự" )
	private String firstname;
	
	@NotBlank(message = "Không thể để trống")
	@Length(max = 12, min = 6, message = "Tên phải từ 6-12 kí tự" )
	private String lastname;
	
	@NotBlank(message = "Không thể để trống")
	@CheckEmailNotExists
	@EmailValidator
	private String email;
	
	@Length(max = 12, min = 10, message = "Số điện thoại phải từ 10-12 số" )
	@NotNull(message = "Không thể để trống")
	@CheckPhonNumberExists
	private String phoneNumber;
	
	@NotBlank(message = "Không thể để trống")
	private String city;
	
	@NotBlank(message = "Không thể để trống")
	private String district;
	
	@NotBlank(message = "Không thể để trống")
	private String ward;
	
	@NotBlank(message = "Không thể để trống")
	private String street;
	
	@Length(min = 8, message = "Mật khẩu phải từ 8 kí tự" )
	@NotNull(message = "Không thể để trống")
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
