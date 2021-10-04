package com.vti.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.vti.validation.CheckEmailNotExists;
import com.vti.validation.EmailValidator;
import com.vti.validation.PasswordValidator;

public class AccountUpdateRequest {

	@Length(min = 6, max = 50, message = "Độ dài FullName không hợp lệ")
	private String fullname;
	
	@CheckEmailNotExists(message = "Email này đã có trên hệ thống, hãy lựa chọn Email khác!!")
	@EmailValidator
	private String email;
	
//	@Nullable
	@Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{8}$", 
			message = "Định dạng số điện thoại không đúng")
	private String phoneNumber;
	
	@Nullable
	private String address;
	
	@PasswordValidator
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}


