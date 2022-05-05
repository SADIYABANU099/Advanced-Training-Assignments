package com.mycompany.domain;
/*POJO - plain old java object - classes which are supposed to hold data */
public class Product {

    //since this class holds the same data as the db table, it should have the same fields as the table
    String productId;
    String productName;
    int productPrice;

    //default constructor
    public Product(){

    }

    public Product(String productid, String productName, int productPrice) {
        this.productId = productid;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    //getter and setters


    public String getProductid() {
        return productId;
    }

    public void setProductid(String productid) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString(){
        return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + "]";
    }

}



		