package com.books;



import java.util.Scanner;

public class TestBook {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Book title");
		String booktitle=sc.nextLine();
		
		System.out.println("Enter the Book price");
		int price=sc.nextInt();
		sc.nextLine();
		
		Book n=new Book();
		n.setBooktitile(booktitle);
		n.setBookprice(price);
		System.out.println("Book Details");
		System.out.println("Book Title :"+n.getBooktitile());
		System.out.println("Book Price :"+n.getBookprice());
		
	}

}
