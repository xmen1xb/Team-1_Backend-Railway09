package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`registration_account_tokens`", catalog = "Mock_Project")
public class RegistationAccountToken implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "token", nullable = false, length = 40, unique = true)
	private String token;

	@OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "account_id")
	private Account account;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiryDate", nullable = false)
	private Date expiryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public RegistationAccountToken(Long id, String token, Account account, Date expiryDate) {
		super();
		this.id = id;
		this.token = token;
		this.account = account;
		this.expiryDate = expiryDate;
	}

	public RegistationAccountToken() {
		super();
	}
	
	public RegistationAccountToken(String token, Account user) {
		this.token = token;
		this.account = user;

		// 1h
		expiryDate = new Date(System.currentTimeMillis() + 360000);
	}
}
