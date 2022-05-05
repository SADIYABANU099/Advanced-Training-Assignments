package com.banu.service;



import java.util.List;

import com.banu.model.Product;

public interface ProductService {
	
	Long addProduct(Product product);

	List<Product> getAllProducts();
	
	Product editProduct(Product product);
	
	Product getProductById(Long id);
	
	Product deletProduct(Long id);
}

