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
@Table(name = "Cart", catalog = "Mock_Project")
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cart_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@Column(name = "quantity")
	private short quantity;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	private Account cartAccount;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	private List<CartDetail> listCartDetail;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(short quantity, Double total_price, Account account, List<CartDetail> listCartDetail) {
		super();
		this.quantity = quantity;
		this.totalPrice = total_price;
		this.cartAccount = account;
		this.listCartDetail = listCartDetail;
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

	public Account getAccount() {
		return cartAccount;
	}

	public void setAccount(Account account) {
		this.cartAccount = account;
	}

	public List<CartDetail> getListCartDetail() {
		return listCartDetail;
	}

	public void setListCartDetail(List<CartDetail> listCartDetail) {
		this.listCartDetail = listCartDetail;
	}

	public int getCart_id() {
		return cartId;
	}
}
