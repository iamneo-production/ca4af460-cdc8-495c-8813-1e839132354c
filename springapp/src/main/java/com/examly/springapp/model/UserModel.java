package com.examly.spring.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserModel {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="active")
	private boolean active=true;
	
	@Column(name="role")
	private String role="User";
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonBackReference
	private CartModel cart;

	public UserModel() {
		
	}
	
	public UserModel(
			String email,
			String password,
			String username,
			String mobileNumber
			){
		
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.mobileNumber = mobileNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public CartModel getCart() {
		return cart;
	}
	public void setCart(CartModel cart) {
		this.cart = cart;
	}
}
