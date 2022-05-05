package com.banu.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banu.dao.ProductDao;
import com.banu.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Long addProduct(Product product) {
		
		return this.productDao.addProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return this.productDao.getAllProducts();
	}

	@Override
	public Product editProduct(Product product) {
		
		return this.productDao.editProduct(product);
	}

	@Override
	public Product getProductById(Long id) {
		
		return this.productDao.getProductById(id);
	}

	@Override
	public Product deletProduct(Long id) {
		
		return this.productDao.deleteProduct(id);
	}

}

    
