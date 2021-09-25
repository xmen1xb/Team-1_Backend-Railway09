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

import com.vti.enumerate.Gender;
import com.vti.enumerate.Role;

@Entity
@Table(name = "`accounts`", catalog = "Mock_Project")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "account_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", length = 255, nullable = false, unique = true)
	private String username;

	@Column(name = "fullname", length = 255, nullable = false)
	private String fullname;
	
	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@Column(name = "register_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date registerDate;
	
	@Column(name = "`status`")
	private short status = 1;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.UNKNOWN;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "city", length = 255)
	private String city;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;

	@Column(name = "phone", length = 255)
	private String phone;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;
	
	@OneToMany(mappedBy = "account")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })   //xoá cha thì xoá cả các con
	private List<Order> orders;
	
	@OneToMany(mappedBy = "account")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })   //xoá cha thì xoá cả các con
	private List<Cart> carts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Account(Long id, String username, String fullname, String email, String password, Date registerDate,
			short status, Gender gender, String image, String city, String address, String phone, Role role,
			List<Order> orders, List<Cart> carts) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.registerDate = registerDate;
		this.status = status;
		this.gender = gender;
		this.image = image;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.role = role;
		this.orders = orders;
		this.carts = carts;
	}

	public Account() {
		super();
	}
	
}
