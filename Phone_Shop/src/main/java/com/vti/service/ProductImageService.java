package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Product;
import com.vti.entity.ProductImage;
import com.vti.exception.NotFoundException;
import com.vti.repository.IProductImageRepository;
import com.vti.repository.IProductRepository;
import com.vti.request.ProductImageRequest;

@Service
public class ProductImageService implements IProductImageService{

	@Autowired
	private IProductImageRepository imageRepo;
	
	@Autowired
	private IProductRepository productRepo;

	@Override
	public void createIMGforProduct(int productID, ProductImageRequest request) {
		Product product = productRepo.getById(productID);
		if (product == null) {
			throw new NotFoundException("Sản phẩm không tồn tại");	
		}
		ProductImage img = new ProductImage(request.getPathIMG(), product);
		imageRepo.save(img);
	}

}
