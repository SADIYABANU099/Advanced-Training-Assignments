package com.sadiyaapp.dbutil;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private Connection connection;
	
	public DBUtil(String url , String username , String password) {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
 
			this.connection = DriverManager.getConnection(url, username, password);
 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  Connection getConnection() {
		
		return this.connection;
	}
	
	public void closeConnection() {
		
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	

}


