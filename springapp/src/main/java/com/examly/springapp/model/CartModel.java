package com.examly.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class CartModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cart_id")
    private int cartItemId;

    @ManyToMany
    @JoinTable(
            name = "CART_PRODUCTS",
            joinColumns = @JoinColumn(name="cart_id", referencedColumnName = "cart_id"),
            inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName = "product_id")
    )
    private List<ProductModel> products;

    @Column(name="quantity")
    private int Quantity;

    @Column(name="price")
    private String price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserModel user;

    public CartModel() {
        super();
        this.products = new ArrayList<ProductModel>();
        this.Quantity = 0;
        this.price = "0";
    }


    public UserModel getUser() {
        return user;
    }



    public void setUser(UserModel user) {
        this.user = user;
    }



    public List<ProductModel> getProducts() {
        return products;
    }



    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public void addProduct(ProductModel product){ this.products.add(product); }



    public int getQuantity() {
        return Quantity;
    }



    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }



    public String getPrice() {
        return price;
    }



    public void setPrice(String price) {
        this.price = price;
    }


}