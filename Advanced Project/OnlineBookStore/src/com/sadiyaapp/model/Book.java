package com.sadiyaapp.model;





public class Book {
	
	private Long id;
	
	private String bookname;
	
	private String author;
	
	private double price;
	
	private int stocks;

	public Book() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", author=" + author + ", price=" + price + ", stocks="
				+ stocks + "]";
	}
	
	
	
	

}
