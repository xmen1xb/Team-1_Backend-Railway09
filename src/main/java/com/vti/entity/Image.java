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
@Table(name = "product_images", catalog = "Mock_Project")
public class Image implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "image_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "path_image", length = 255)
	private String path;
	
	@ManyToOne(fetch = FetchType.LAZY)      //thể hiện mối quan hệ 1 department có nhiều account
	@JoinColumn(name = "product_id", nullable = false)   // định nghĩa cột foreign key trong bảng Account, tức là trường department này nối với cột departmentID trong bảng Account của db
	@Cascade(value = { CascadeType.SAVE_UPDATE }) //
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Image() {
		super();
	}

	public Image(Long id, String path, Product product) {
		super();
		this.id = id;
		this.path = path;
		this.product = product;
	}
}
