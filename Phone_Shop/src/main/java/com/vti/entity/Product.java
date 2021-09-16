package com.vti.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Product", catalog = "Mock_Project")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "product_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(name = "product_name", length = 100, nullable = false)
	private String productName;
	
	@Column(name = "`description`", length = 1000)
	private String description;
	
	@Column(name = "discount", nullable = true)
	private short discount = 0;
	
	@Column(name = "price")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "productRam_id", nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private ProductRam ram;
	
	@ManyToOne
	@JoinColumn(name = "productMemory_id", nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private ProductMemory memory;
	
	@ManyToOne
	@JoinColumn(name = "productBrand_id", nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private ProductBrand brand;
	
	@Column(name = "category")
	private String  category;
	
	@Column(name = "quantity")
	private short quantity;
	
	@Column(name = "enter_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date enterDate;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProductImage> listProductImage;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<CartDetail> listCartDetail;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL, CascadeType.SAVE_UPDATE })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<OrderDetail> listOrderDetail;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, String description, short discount, Double price, ProductRam ram, ProductMemory memory,
			ProductBrand brand, String category, short quantity, Date enter_date) {
		super();
		this.productName = productName;
		this.description = description;
		this.discount = discount;
		this.price = price;
		this.ram = ram;
		this.memory = memory;
		this.brand = brand;
		this.category = category;
		this.quantity = quantity;
		this.enterDate = enter_date;
	}

	public int getProduct_id() {
		return productId;
	}

	public String getProduct_name() {
		return productName;
	}

	public void setProduct_name(String product_name) {
		this.productName = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getDiscount() {
		return discount;
	}

	public void setDiscount(short discount) {
		this.discount = discount;
	}

	public String getPrice() {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(Double.valueOf(price));
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductRam getRam() {
		return ram;
	}

	public void setRam(ProductRam ram) {
		this.ram = ram;
	}

	public ProductMemory getMemory() {
		return memory;
	}

	public void setMemory(ProductMemory memory) {
		this.memory = memory;
	}

	public ProductBrand getBrand() {
		return brand;
	}

	public void setBrand(ProductBrand brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public Date getEnter_date() {
		return enterDate;
	}

	public void setEnter_date(Date enter_date) {
		this.enterDate = enter_date;
	}
	
}
