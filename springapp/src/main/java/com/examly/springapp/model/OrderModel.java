package com.examly.spring.model;

import javax.persistence.*;

@Entity
@Table(name="order_record")
public class OrderModel {
	@Id
	@Column(name="order_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderId;

	@Column(name="user_id")
	private int userId;

	@Column(name="product_name")
 	private String productName;

	@Column(name="quantity")
	private Integer quantity;

	@Column(name="total_price")
	private String totalPrice;

	@Column(name="status")
	private String status;

	@Column(name="price")
	private String price;

	public Integer getOrderId() {
		return orderId;
	}

	public OrderModel(Integer orderId, int userId, String productName, int quantity, String totalPrice, String status,
                      String price) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public OrderModel setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public OrderModel setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public OrderModel setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public OrderModel setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public OrderModel setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getPrice() {
		return price;
	}

	public OrderModel setPrice(String price) {
		this.price = price;
		return this;
	}

	public OrderModel() {

	}

}
