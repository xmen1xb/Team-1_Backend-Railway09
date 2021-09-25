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
@Table(name = "cart_details", catalog = "Mock_Project")
public class CartDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@ManyToOne      //thể hiện mối quan hệ 1 department có nhiều account
	@JoinColumn(name = "cart_id", nullable = false)   // định nghĩa cột foreign key trong bảng Account, tức là trường department này nối với cột departmentID trong bảng Account của db
	@Cascade(value = { CascadeType.SAVE_UPDATE }) //
	private Cart cart;
	
	@ManyToOne      //thể hiện mối quan hệ 1 department có nhiều account
	@JoinColumn(name = "product_id", nullable = false)   // định nghĩa cột foreign key trong bảng Account, tức là trường department này nối với cột departmentID trong bảng Account của db
	@Cascade(value = { CascadeType.SAVE_UPDATE }) //
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
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartDetail(Long id, Double price, Integer quantity, Cart cart, Product product) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}

	public CartDetail() {
		super();
	}
	
	
}
