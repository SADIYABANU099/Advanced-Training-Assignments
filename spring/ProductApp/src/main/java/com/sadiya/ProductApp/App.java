package com.sadiya.ProductApp;




import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.banu.configuration.AppConfig;
import com.banu.configuration.DBConfig;
import com.banu.model.Product;
import com.banu.service.ProductService;

import antlr.collections.List;

public class App 
{
	@Autowired
	private ProductService productService;
	
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class,AppConfig.class);
    	Scanner scannerObj = new Scanner(System.in);

    	App myApp = context.getBean(App.class);
    	
	    first:while(true) {	
	    	System.out.println("***** Welcome ******\n");
	    	
	    	System.out.println("*** Operations *****\n");
	    	
	    	System.out.println("1.Add Product\n"
	    			+ "2.Find Product By Id\n"
	    			+ "3.Delete product by Id\n"
	    			+ "4.Update product By Id\n"
	    			+ "5.Find All products\n"
	    			+ "6.Exit\n");
	    		    	
	    	System.out.print("Enter Your Choice : ");
	    	int choice = scannerObj.nextInt();
	    	scannerObj.nextLine();
	    	System.out.println("=======================================================\n");
	    	
	    	switch (choice) {
	    	
			case 1:
				   System.out.print("Enter Product Name : ");
				   String pname = scannerObj.nextLine();
				   
				   System.out.print("Enter Product price : ");
				   double price = scannerObj.nextDouble();
				   
				   System.out.print("Enter Product Quantity : ");
				   int quantity = scannerObj.nextInt();
				   
				   Product addProduct = new Product();
				   
				   addProduct.setProductName(pname);
				   addProduct.setProductPrice(price);
				   addProduct.setProductQuantity(quantity);
				   

				   if(result>0) {
					   
					   System.out.println("Product addedd successfully !!\n");
					   break;
				   }
				   System.out.println("Product not added!!\n");
				   
				   break;
				   
			case 2: 
				   System.out.print("Enter Product Id : ");
				   Long id = scannerObj.nextLong();
				   
				   Product searchProduct = myApp.productService.getProductById(id);
				   if(searchProduct != null) {
					   
					   System.out.println("Product Details : ");
					   System.out.println("Id :"+searchProduct.getProductId());
					   System.out.println("Name :"+searchProduct.getProductName());
					   System.out.println("Price :"+searchProduct.getProductPrice());
					   System.out.println("Quantity :"+searchProduct.getProductQuantity()+"\n");
					   
					   break;

				   }
				   System.out.println("Product Not found with this id !!\n");
				   
				   break;
			case 3:
				 	System.out.print("Enter Product Id : ");
				    Product deleteProduct = myApp.productService.deletProduct(scannerObj.nextLong());
				    if(deleteProduct != null) {
				    	
				    	System.out.println("Product deleted successfully !!\n");
				    	break;
				    }
				    System.out.println("Sorry can't delete product , as Product not available with this id!!\n");
				    break;
			case 4:
				   System.out.print("Enter product Id : ");
				   Product updateProduct = myApp.productService.getProductById(scannerObj.nextLong());
				   if(updateProduct !=null) {
					   
					   scannerObj.nextLine();
					   System.out.print("Enter New Product Name : ");
					   updateProduct.setProductName(scannerObj.nextLine());
					   
					   System.out.print("Enter New Product Price : ");
					   updateProduct.setProductPrice(scannerObj.nextDouble());
					   
					   System.out.print("Enter New Product Quantity : ");
					   updateProduct.setProductQuantity(scannerObj.nextInt());
					   
					   myApp.productService.editProduct(updateProduct);
					   
					   System.out.println("Product Successfully updated !!\n");
					   break;

				   }
				   System.out.println("Sorry , can't update product not found with this id !!\n");
				   break;
			case 5:
				   List<Product> products = myApp.productService.getAllProducts();
				   if(products.isEmpty()) {
					   
					   System.out.println("Currently no products available !!\n");
					   break;
				   }
				   System.out.println("*** Products List ***");
				   for(Product pro:products) {
					   
					   System.out.println("Id : "+pro.getProductId());
					   System.out.println("Name : "+pro.getProductName());
					   System.out.println("Price : "+pro.getProductPrice());
					   System.out.println("Quantity : "+pro.getProductQuantity());
					   
					   System.out.println();

				   }
				   System.out.println("\n");
				   break;
			case 6:
					System.out.println("\n");
					break first;
			default:
				  System.out.println("Invalid choice !!\n");
				  continue;
			}
	    	
	    }
	    
	    System.out.println("*** Thank You ****");
    	scannerObj.close();
    	context.close();
    }
}

    