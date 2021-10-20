package com.example.springapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class UserModel {
    public UserModel() {
    }

    public UserModel(String email, String password, String username, String mobileNumber, Boolean active, String role, List<CartModel> cart, List<OrderModel> ordersList) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.active = active;
        this.role = role;
        this.cart = cart;
        this.ordersList = ordersList;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<CartModel> getCart() {
        return cart;
    }

    public void setCart(List<CartModel> cart) {
        this.cart = cart;
    }

    public List<OrderModel> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrderModel> ordersList) {
        this.ordersList = ordersList;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String email;
    private String password;
    private String username;
    private String mobileNumber;
    private Boolean active;
    private String role;
    private List<CartModel> cart;
    private List<OrderModel> ordersList;


}
