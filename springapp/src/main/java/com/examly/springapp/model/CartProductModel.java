package com.examly.spring.model;

import javax.persistence.*;


@Entity
@Table(name="cart_product")
public class CartProductModel {

    @Id
    @Column(name="cart_product_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private CartModel cart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private ProductModel product;

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

    public CartModel getCart() {
        return cart;
    }

    public CartProductModel setCart(CartModel cart) {
        this.cart = cart;
        return this;
    }

    public ProductModel getProduct() {
        return product;
    }

    public CartProductModel setProduct(ProductModel product) {
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
