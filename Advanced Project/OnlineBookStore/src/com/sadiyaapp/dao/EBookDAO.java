package com.sadiyaapp.dao;


import java.sql.Timestamp;
import java.util.List;

import com.sadiyaapp.model.Book;
import com.sadiyaapp.model.User;

public interface EBookDAO {
    
	int registerUsers(String name , String address ,String email , String userName, String password , Timestamp registerDate);
	
	User validateLogin(String username , String password);
	
	List<Book> getAllAvailableBooks();
	
	Book getBookById(Long bookid);
	
	int addOrder(Long bookId, String custName , String phoneno, String address, Timestamp orderDate, int quantity);
	
	boolean verifyUser(String email , String userName);
	
	int resetPassword(String email , String username ,String newPassword);
	
}
