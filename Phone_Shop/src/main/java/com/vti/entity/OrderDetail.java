package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "order_details", catalog = "Mock_Project")
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@ManyToOne      
	@JoinColumn(name = "order_id", nullable = false)   
	@Cascade(value = { CascadeType.SAVE_UPDATE }) 
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)   
	@Cascade(value = { CascadeType.SAVE_UPDATE }) 
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderDetail(Long id, Double price, Integer quantity, Order order, Product product) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
	}

	public OrderDetail() {
		super();
	}
}
