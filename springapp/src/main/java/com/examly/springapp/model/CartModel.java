package com.examly.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name="cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cart_id")
    private int cartId;

    @Column(name="quantity")
    private int Quantity;

    @Column(name="price")
    private String price;

    @OneToOne
    @JoinColumn(name="user_id")
    private UserModel user;

    @OneToMany(mappedBy="cart",orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<CartProductModel> cartProductModel = new ArrayList<>();

    public CartModel() {
        super();
        this.Quantity = 0;
        this.price = "0";
    }

    public UserModel getUser() {
        return user;
    }

    public CartModel setUser(UserModel user) {
        this.user = user;
        return this;
    }


    public String getPrice() {
        return price;
    }

    public CartModel setPrice(String price) {
        this.price = price;
        return this;
    }

    public int getCartId() { return cartId; }

    public int getQuantity() {
        return Quantity;
    }

    public CartModel setQuantity(int quantity) {
        Quantity = quantity;
        return this;
    }

    public List<CartProductModel> getCartProductModel() {
        return cartProductModel;
    }

    public CartModel setCartProductModel(List<CartProductModel> cartProductModel) {
        this.cartProductModel = cartProductModel;
        return this;
    }

    @Transactional
    public void removeProduct(ProductModel product) {
        cartProductModel.removeIf(cartProduct -> cartProduct.getProduct() == product.getProductId());
    }
}