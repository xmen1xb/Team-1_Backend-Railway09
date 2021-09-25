package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "carts", catalog = "Mock_Project")
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "address", length = 255)
	private String address;
	
	@Column(name = "amount")
	private Double price;
	
	@Column(name = "phone", length = 255)
	private String phone;
	
	@Column(name = "status")
	private short status = 1;
	
//	@Column(name = "quantity")
//	private Integer quantity;
	
	@ManyToOne     //thể hiện mối quan hệ 1 department có nhiều account
	@JoinColumn(name = "account_id", nullable = false)   // định nghĩa cột foreign key trong bảng Account, tức là trường department này nối với cột departmentID trong bảng Account của db
	@Cascade(value = { CascadeType.SAVE_UPDATE }) //
	private Account account;
	
	@OneToMany(mappedBy = "cart")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })   //xoá cha thì xoá cả các con
	private List<CartDetail> cartDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public Cart(Long id, String address, Double price, String phone, short status, Account account,
			List<CartDetail> cartDetails) {
		super();
		this.id = id;
		this.address = address;
		this.price = price;
		this.phone = phone;
		this.status = status;
//		this.quantity = quantity;
		this.account = account;
		this.cartDetails = cartDetails;
	}

	public Cart() {
		super();
	}
}
