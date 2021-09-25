package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "`orders`", catalog = "Mock_Project")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "address", length = 255)
	private String address;

	@Column(name = "amount")
	private Double price;

	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date orderDate;

	@Column(name = "phone", length = 255)
	private String phone;

	@Column(name = "status")
	private short status = 3;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false) 								
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private Account account;

	@OneToMany(mappedBy = "order")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE }) 
	private List<OrderDetail> orderDetails;

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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order(Long id, String address, Double price, Date orderDate, String phone, short status, Account account,
			List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.address = address;
		this.price = price;
		this.orderDate = orderDate;
		this.phone = phone;
		this.status = status;
		this.account = account;
		this.orderDetails = orderDetails;
	}

	public Order() {
		super();
	}

}
