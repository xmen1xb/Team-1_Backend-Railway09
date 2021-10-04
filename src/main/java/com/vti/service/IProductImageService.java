package com.vti.service;

import com.vti.request.ProductImageRequest;

public interface IProductImageService {	
	
	public void createIMGforProduct(int productID, ProductImageRequest request);
	
}
