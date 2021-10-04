package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "memories", catalog = "Mock_Project")
public class Memory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "memory_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "memory_name", length = 100, nullable = false, unique = true)
	private String memoryName;
	
	@OneToMany(mappedBy = "memory")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemoryName() {
		return memoryName;
	}

	public void setMemoryName(String memoryName) {
		this.memoryName = memoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Memory(Long id, String memoryName, List<Product> products) {
		super();
		this.id = id;
		this.memoryName = memoryName;
		this.products = products;
	}

	public Memory() {
		super();
	}

}
