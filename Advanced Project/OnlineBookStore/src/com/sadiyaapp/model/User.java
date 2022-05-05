package com.sadiyaapp.model;


import java.sql.Timestamp;

public class User {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private Timestamp registrationDate;
	

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
	

}

