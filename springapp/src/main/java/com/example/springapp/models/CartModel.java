package com.example.springapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartModel {

    public CartModel(String cartItemID, UserModel userId, String productName, int quantity, String price) {
        this.cartItemID = cartItemID;
        this.userId = userId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public CartModel() {

    }

    public String getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(String cartItemID) {
        this.cartItemID = cartItemID;
    }

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String cartItemID;
    @ManyToOne
    @JoinColumn(name = "user_id_email")
    private UserModel userId;
    private String productName;
    private int quantity;
    private String price;
}
