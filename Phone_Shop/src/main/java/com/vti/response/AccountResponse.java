package com.vti.response;

import java.util.Date;

import com.vti.enumerate.AccountGenderEnum;

public class AccountResponse {

	private int id;
	private String username;
	private String fullname;
	private String email;
	private AccountGenderEnum gender;
	private String phonenumber;
	private String address;
	private Date registerdate;
	
	public AccountResponse() {
		// TODO Auto-generated constructor stub
	}

	public AccountResponse(int id, String username, String fullname, String email, AccountGenderEnum gender,
			String phone_number, String address, Date register_date) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.gender = gender;
		this.phonenumber = phone_number;
		this.address = address;
		this.registerdate = register_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public AccountGenderEnum getGender() {
		return gender;
	}

	public void setGender(AccountGenderEnum gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return phonenumber;
	}

	public void setPhone_number(String phone_number) {
		this.phonenumber = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegister_date() {
		return registerdate;
	}

	public void setRegister_date(Date register_date) {
		this.registerdate = register_date;
	}
}
