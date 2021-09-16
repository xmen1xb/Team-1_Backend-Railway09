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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.vti.enumerate.ProductImageStatus;

@Entity
@Table(name = "ProductImage", catalog = "Mock_Project")
public class ProductImage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "image_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int image_id;
	
	@Column(name = "path_image", length = 100)
	private String path_image;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "`status`", nullable = false)
	private ProductImageStatus status = ProductImageStatus.NOT_ACTIVE;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	private Product product;
	
	public ProductImage() {
		// TODO Auto-generated constructor stub
	}

	public ProductImage(String path_image, ProductImageStatus status, Product product) {
		super();
		this.path_image = path_image;
		this.status = status;
		this.product = product;
	}

	public String getPath_image() {
		return path_image;
	}

	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}

	public ProductImageStatus getStatus() {
		return status;
	}

	public void setStatus(ProductImageStatus status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getImage_id() {
		return image_id;
	}
}
