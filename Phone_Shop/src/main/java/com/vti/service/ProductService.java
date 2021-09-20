package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.entity.Product;
import com.vti.repository.IProductRepository;
import com.vti.request.ProductFilterRequest;
import com.vti.specification.ProductSpecification;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductRepository product_repo;
	
	@SuppressWarnings("deprecation")
	@Override
	public Page<Product> getAllProducts(Pageable pageable, String search, ProductFilterRequest filter) {
		Specification<Product> where = null;
		
		if (!StringUtils.isEmpty(search)) {
			ProductSpecification nameSpecification = new ProductSpecification("productName", "LIKE", search);
			where = Specification.where(nameSpecification);			
		}
		
		if (filter != null && filter.getBrandName() != null) {
			ProductSpecification brandFilter = new ProductSpecification("brand.brandName", "=", filter.getBrandName());
			if (where == null) {
				where = Specification.where(brandFilter);
			}else {
				where = where.and(brandFilter);
			}
		}
		
		if (filter != null && filter.getMemoryName() != null) {
			ProductSpecification memoryFilter = new ProductSpecification("memory.memoryName", "=", filter.getMemoryName());
			if (where == null) {
				where = Specification.where(memoryFilter);
			}else {
				where = where.and(memoryFilter);
			}
		}
		
		if (filter != null && filter.getRamName() != null) {
			ProductSpecification memoryFilter = new ProductSpecification("ram.ramName", "=", filter.getRamName());
			if (where == null) {
				where = Specification.where(memoryFilter);
			}else {
				where = where.and(memoryFilter);
			}
		}
		
		return product_repo.findAll(where, pageable);
	}

	@Override
	public Product getProductById(int id) {

		return product_repo.getById(id);
	}

	@Override
	public void deleteProduct(int id) {
		product_repo.deleteById(id);
		
	}

}
