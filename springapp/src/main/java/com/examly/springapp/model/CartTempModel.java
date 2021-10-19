package com.examly.spring.model;

public class CartTempModel {

    private ProductModel product;
    private Integer quantity;

    public ProductModel getProduct() {
        return product;
    }

    public CartTempModel setProduct(ProductModel product) {
        this.product = product;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CartTempModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
