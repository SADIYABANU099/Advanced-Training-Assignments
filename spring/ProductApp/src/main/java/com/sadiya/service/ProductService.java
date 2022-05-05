package com.sadiya.service;


import com.banu.model.Product;

import antlr.collections.List;

public interface ProductService {
	
	Long addProduct(Product product);

	List<Product> getAllProducts();
	
	Product editProduct(Product product);
	
	Product getProductById(Long id);
	
	Product deletProduct(Long id);

}


