package com.banu.dao;




import java.util.List;

import com.banu.model.Product;

public interface ProductDao {
	
	Long addProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product editProduct(Product product);
	
	Product getProductById(Long id);
	
	Product deleteProduct(Long id);

}

    
