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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import com.vti.enumerate.OrderStatusEnum;

@Entity
@Table(name = "`Order`", catalog = "Mock_Project")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "order_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name = "quantity")
	private short quantity;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@Column(name = "ship_address", length = 100, nullable = false)
	private String shipAddress;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date orderDate;
	
	@Column(name = "`status`", nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum status = OrderStatusEnum.Not_Active;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	private Account orderAccount;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	private List<OrderDetail> listOrderDetail;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(short quantity, Double total_price, String ship_address, Date order_date, OrderStatusEnum status,
			Account account, List<OrderDetail> listOrderDetail) {
		super();
		this.quantity = quantity;
		this.totalPrice = total_price;
		this.shipAddress = ship_address;
		this.orderDate = order_date;
		this.status = status;
		this.orderAccount = account;
		this.listOrderDetail = listOrderDetail;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public Double getTotal_price() {
		return totalPrice;
	}

	public void setTotal_price(Double total_price) {
		this.totalPrice = total_price;
	}

	public String getShip_address() {
		return shipAddress;
	}

	public void setShip_address(String ship_address) {
		this.shipAddress = ship_address;
	}

	public Date getOrder_date() {
		return orderDate;
	}

	public void setOrder_date(Date order_date) {
		this.orderDate = order_date;
	}

	public OrderStatusEnum getStatus() {
		return status;
	}

	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}

	public Account getAccount() {
		return orderAccount;
	}

	public void setAccount(Account account) {
		this.orderAccount = account;
	}

	public List<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public int getOrder_id() {
		return orderId;
	}
}
