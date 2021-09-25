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

import com.vti.enumerate.Category;

@Entity
@Table(name = "products", catalog = "Mock_Project")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "`description`", length = 4000)
	private String description;
	
	@Column(name = "discount")
	private Double discount;

	@Column(name = "entered_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date enteredDate;

	@Column(name = "image")
	private String image;

	@Column(name = "name", length = 255)
	private String productName;

	@Column(name = "price")
	private Double price;
	
	@Column(name = "quantity")
	private short quantity;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)  
	@Cascade(value = { CascadeType.SAVE_UPDATE }) //
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY)      
	@JoinColumn(name = "ram_id", nullable = false)  
	@Cascade(value = { CascadeType.SAVE_UPDATE }) 
	private Ram ram;

	@ManyToOne(fetch = FetchType.LAZY)      
	@JoinColumn(name = "memory_id", nullable = false)  
	@Cascade(value = { CascadeType.SAVE_UPDATE }) //
	private Memory memory;

	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private Category category;

	@OneToMany(mappedBy = "product")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })   
	private List<OrderDetail> orderDetails;

	@OneToMany(mappedBy = "product")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })  
	private List<CartDetail> cartDetails;

	@OneToMany(mappedBy = "product")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })   
	private List<Image> images;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Product(Long id, String description, Double discount, Date enteredDate, String image, String productName,
			Double price, short quantity, Brand brand, Ram ram, Memory memory, Category category,
			List<OrderDetail> orderDetails, List<CartDetail> cartDetails, List<Image> images) {
		super();
		this.id = id;
		this.description = description;
		this.discount = discount;
		this.enteredDate = enteredDate;
		this.image = image;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.ram = ram;
		this.memory = memory;
		this.category = category;
		this.orderDetails = orderDetails;
		this.cartDetails = cartDetails;
		this.images = images;
	}

	public Product() {
		super();
	}

}
