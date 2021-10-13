package com.examly.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="order")
public class OrderModel {
	@Id
	@Column(name="order_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@Column(name="product_name")
 	private String productName;

	@Column(name="quantity")
	private int quantity;

	@Column(name="total_price")
	private String totalPrice;

	@Column(name="status")
	private String status;

	@Column(name="price")
	private String price;

	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name="user_id")
	private List<UserModel> user;

	public OrderModel() {
		super();
        String orderId;
        String userId;
        String productName;
        String quantity;
        String totalPrice;
        String status;
        String price;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public List<UserModel> getUser() {
		return user;
	}

	public void setUser(List<UserModel> user) {
		this.user = user;
	}


}
