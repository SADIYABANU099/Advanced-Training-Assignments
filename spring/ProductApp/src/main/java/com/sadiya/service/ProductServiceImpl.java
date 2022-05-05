package com.sadiya.service;



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

    
