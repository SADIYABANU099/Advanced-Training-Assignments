package com.banu.dao;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banu.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	@Transactional
	public Long addProduct(Product product) {
		
		return (Long) this.hibernateTemplate.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return this.hibernateTemplate.loadAll(Product.class);
	}

	@Override
	@Transactional
	public Product editProduct(Product product) {
		
		this.hibernateTemplate.update(product);
		return product;
	}

	@Override
	public Product getProductById(Long id) {
		
		return this.hibernateTemplate.get(Product.class, id);
	}

	@Override
	@Transactional
	public Product deleteProduct(Long id) {
		
		Product product = this.getProductById(id);
		
		this.hibernateTemplate.delete(product);
		
		return product;
	}
    
	
}

    
