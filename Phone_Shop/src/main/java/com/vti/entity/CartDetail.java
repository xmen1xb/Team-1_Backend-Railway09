package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	private short quantity;
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	private Product product;
	
	public CartDetail() {
		// TODO Auto-generated constructor stub
	}

	public CartDetail(Double price, short quantity, Cart cart, Product product) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
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

	public int getCartdetail_id() {
		return cartdetailId;
	}
}
