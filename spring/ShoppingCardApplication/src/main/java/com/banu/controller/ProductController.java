package com.banu.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.banu.model.Product;
import com.banu.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceImp productService;
	
	@GetMapping("/")
	public String getHomePage() {
		
		return "Home";
	}
	
	@GetMapping("/add")
	public String getAddProductPage() {
		
		return "AddProduct";
	}
	
	@GetMapping("/view/products")
	public String getProductDetailsPage(Model model) {
		
		List<Product> allProducts = this.productService.getAllProducts();
		
		model.addAttribute("products", allProducts);
		
		return "ProductsList";
	}
	
	@GetMapping("/edit/{pid}")
	public String getEditProductPage(@PathVariable("pid") Long productId , Model model) {
		
		model.addAttribute("productid", productId);
		return "EditProduct";
		
	}
	
	@GetMapping("/delete/{pid}")
	public String getDeleteProductConfirmationPage(@PathVariable("pid") Long productId , Model model) {
	   
		Product product = this.productService.getProductById(productId);
		
		model.addAttribute("product", product);
		
		return "DeleteConfirmation";
	}
	
	@GetMapping("/delete/product/{pid}")
	public String deleteProduct(@PathVariable("pid") Long productId , Model model) {
		
		Product product = this.productService.deletProduct(productId);
		
		if(product != null) {
			model.addAttribute("mssg", "Product with Id "+product.getProductId()+" deleted successfully !!");
			return "DeleteProduct";
		}
		
		return "redirect:/view/products";
	}
	
	@PostMapping("/add/product")
	public String addProduct(@ModelAttribute("product") Product myproduct , Model model) {
		
		Long num = this.productService.addProduct(myproduct);
		
		if(num>0)
			model.addAttribute("mssg", num+" product/products is/are added...");
		
		return "AddProductSummary";
		
	}
	
	@PostMapping("/edit/product")
	public String editProduct(@ModelAttribute("product") Product product) {
		
	
		this.productService.editProduct(product);
		
		return "EditProductSummary";
	}

	
}

 
