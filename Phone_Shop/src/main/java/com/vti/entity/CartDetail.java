package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vti.enumerate.CartDetailStatus;

@Entity
@Table(name = "CartDetail", catalog = "Mock_Project")
public class CartDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cartdetail_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartdetailId;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "`status`")
	private CartDetailStatus status = CartDetailStatus.Not_Order;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productInCartdetail;
	
	public CartDetail() {
		
	}

	public CartDetail(Double price, int quantity, Cart cart, Product product) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
		this.productInCartdetail = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return productInCartdetail;
	}

	public void setProduct(Product product) {
		this.productInCartdetail = product;
	}

	public int getCartdetail_id() {
		return cartdetailId;
	}

	public CartDetailStatus getStatus() {
		return status;
	}

	public void setStatus(CartDetailStatus status) {
		this.status = status;
	}
}
