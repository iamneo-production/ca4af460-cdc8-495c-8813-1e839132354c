package com.example.springapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductModel {

    public ProductModel(String productId, String imageUrl, String productName, String price, String description, String quantity) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductModel() {

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String productId;
    private String imageUrl;
    private String productName;
    private String price;
    private String description;
    private String quantity;
}
