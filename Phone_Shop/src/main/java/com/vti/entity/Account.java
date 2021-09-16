package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

import com.vti.enumerate.AccountGenderEnum;
import com.vti.enumerate.AccountRole;
import com.vti.enumerate.AccountStatus;

@Entity
@Table(name = "`Account`", catalog = "Mock_Project")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "account_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "firstname", length = 20, nullable = false)
	private String fistname;
	
	@Column(name = "lastname", length = 30, nullable = false)
	private String lastname;

	@Formula("concat(firstname, ' ', lastname)")
	private String fullname;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private AccountGenderEnum gender = AccountGenderEnum.Unknow;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone_number", length = 12, nullable = false, unique = true)
	private String phonenumber;
	
	@Column(name = "city", length = 12, nullable = false, unique = true)
	private String city;
	
	@Column(name = "district", length = 12, nullable = false, unique = true)
	private String district;
	
	@Column(name = "ward", length = 12, nullable = false, unique = true)
	private String ward;
	
	@Column(name = "street", length = 12, nullable = false, unique = true)
	private String street;
	
	@Formula("concat(city, ' ', district, ' ', ward, ' ', street)")
	private String address;
	
	@Column(name = "path_image", length = 500)
	private String pathImage;
	
	@Column(name = "password", length = 255)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "`status`")
	private AccountStatus status = AccountStatus.Not_Active;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "`role`")
	private AccountRole role = AccountRole.User;
	
	@Column(name = "register_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date registerDate;
	
	@OneToMany(mappedBy = "cartAccount", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cart> listcart;
	
	@OneToMany(mappedBy = "orderAccount", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Order> listOrder;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String fistname, String lastname, String email, String phonenumber,
			String password) {
		super();
		this.username = username;
		this.fistname = fistname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFistname() {
		return fistname;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFullname() {
		return fullname;
	}

	public AccountGenderEnum getGender() {
		return gender;
	}

	public void setGender(AccountGenderEnum gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPath_image() {
		return pathImage;
	}

	public void setPath_image(String path_image) {
		this.pathImage = path_image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountRole getRole() {
		return role;
	}

	public void setRole(AccountRole role) {
		this.role = role;
	}

	public Date getRegister_date() {
		return registerDate;
	}

	public void setRegister_date(Date register_date) {
		this.registerDate = register_date;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getAccountId() {
		return accountId;
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
