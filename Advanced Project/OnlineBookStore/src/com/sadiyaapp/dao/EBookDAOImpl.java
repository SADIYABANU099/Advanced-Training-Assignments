package com.sadiyaapp.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sadiyaapp.dao.EBookDAO;
import com.sadiyaapp.dbutil.DBUtil;
import com.sadiyaapp.model.Book;
import com.sadiyaapp.model.User;

public class EBookDAOImpl implements EBookDAO {
	
	private  final Connection CONNECTION;
	
	public EBookDAOImpl(DBUtil dbUtil) {
		
		this.CONNECTION = dbUtil.getConnection();
	}
	

	@Override
	public int registerUsers(String name, String address, String email, String userName, String password,
			Timestamp registerDate) {
		
		
		PreparedStatement statement;
		try {
			statement = CONNECTION.prepareStatement("INSERT INTO USERS(first_name,address,email,username,password,registration_date) "
												+ "VALUES(? , ? , ? , ? , ? , ?)");
			
			statement.setString(1, name);
			statement.setString(2, address);
			statement.setString(3, email);
			statement.setString(4, userName);
			statement.setString(5, password);
			statement.setTimestamp(6, registerDate);
			
			return statement.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

	@Override
	public User validateLogin(String username, String password) {
		
		 User user = null;
		 
		 try {
		
			 PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? && PASSWORD = ?");
			 
			 statement.setString(1, username);
			 statement.setString(2, password);
			 
			 ResultSet result = statement.executeQuery();
			 
			 while(result.next()) {
				 Long userId = result.getLong(1);
				 String name = result.getString(2);
				 String address = result.getString(3);
				 String email = result.getString(4);
				 String uname = result.getString(5);
				 String pass = result.getString(6);
				 Timestamp registerDate = result.getTimestamp(7);
				 
				  user = new User();
				 
				  user.setId(userId);
				  user.setName(name);
				  user.setAddress(address);
				  user.setEmail(email);
				  user.setUsername(uname);
				  user.setPassword(pass);
				  user.setRegistrationDate(registerDate);
				  
				  
			 }
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 
		 return user;
		 
	}

	
	@Override
	public List<Book> getAllAvailableBooks() {
		
		List<Book> listOfBooks = new ArrayList<Book>();
		
		try {
			PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM BOOKS");
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				Book book = new Book();
				
				book.setId(result.getLong(1));
				book.setBookname(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setPrice(result.getDouble(4));
				book.setStocks(result.getInt(5));
				
				listOfBooks.add(book);
			}
			

		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return listOfBooks;
	}
	
	@Override
	public Book getBookById(Long bookid) {
		
		Book book = null;
		
		try {
			PreparedStatement statement = CONNECTION.prepareStatement("select * from books where book_id = ?");
			statement.setLong(1, bookid);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				book = new Book();
				
				book.setId(bookid);
				book.setBookname(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setPrice(result.getDouble(4));
				book.setStocks(result.getInt(5));
				
				
			}
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public int addOrder(Long bookId, String custName, String phoneno, String address, Timestamp orderDate,
			int quantity) {
		
		int result =0;
		try {
			
			PreparedStatement statement =  CONNECTION.prepareStatement("INSERT INTO ORDER_DETAILS(BOOK_ID,CUST_NAME,PHONE_NO,"
					+ "ADDRESS,ORDER_DATE,QUANTITY)"
					+ " VALUES ( ?,?,?,?,?,?)");
			
			statement.setLong(1, bookId);
			statement.setString(2, custName);
			statement.setString(3, phoneno);
			statement.setString(4, address);
			statement.setTimestamp(5, orderDate);
			statement.setInt(6, quantity);
			 
			 result = statement.executeUpdate();
			 
			 
			 if(result != 0) {
				 statement = CONNECTION.prepareStatement("UPDATE BOOKS SET STOCKS = STOCKS - ? WHERE BOOK_ID = ?");
				 statement.setInt(1, quantity );
				 statement.setLong(2, bookId);
				 
				 
				 statement.executeUpdate();
			 }
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean verifyUser(String email, String userName) {
		
		boolean isPresent = false;
		try {
			
			PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? && EMAIL = ?");
			
			statement.setString(1, userName);
			statement.setString(2, email);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				System.out.println("true...");
				isPresent = true;
			}

		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		return isPresent;
	}
	
	@Override
	public int resetPassword(String email, String username ,String newPassword) {
		
		int result = 0;
		
		try {
			
			PreparedStatement statement = CONNECTION.prepareStatement("UPDATE USERS SET PASSWORD = ? WHERE EMAIL = ? && USERNAME = ?");
			
			statement.setString(1, newPassword);
			statement.setString(2, email);
			statement.setString(3, username);
			
			result = statement.executeUpdate();
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	

}

