package com.examly.spring.model;

import javax.persistence.*;


@Entity
@Table(name="cart_product")
public class CartProductModel {

    @Id
    @Column(name="cart_product_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="cart_id")
    private int cart;
    
    @Column(name = "product_id")
    private int product;

    @Column(name="quantity")
    private int quantity;

    public CartProductModel() {
        int quantity=0;
    }

    public Integer getId() {
        return id;
    }

    public CartProductModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public int getCart() {
        return cart;
    }

    public CartProductModel setCart(int cart) {
        this.cart = cart;
        return this;
    }

    public int getProduct() {
        return product;
    }

    public CartProductModel setProduct(int product) {
        this.product = product;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartProductModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
