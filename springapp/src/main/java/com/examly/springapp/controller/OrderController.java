package com.examly.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.OrderModel;
import com.examly.spring.services.OrderServices;

@RestController
public class OrderController {

	@Autowired
	OrderServices orderModelServices;

	@PostMapping("/orders")
	List<OrderModel> getUserProducts(@RequestParam("user_id") int userId){
		return orderModelServices.showOrders(userId);
	}

	@PostMapping("/saveOrder")
	void saveProduct(@RequestParam("user_id") int userId) {
		orderModelServices.saveOrder(userId);
	}

	@PostMapping("/placeOrder")
	void placeOrder(
			@RequestParam("user_id") int userId,
			@RequestParam("product_id") int productId
	){
		orderModelServices.orderPlace(userId, productId);
	}

	@GetMapping("/admin/orders")
	List<OrderModel> getUserProduct(){
		return orderModelServices.showAllOrders();
	}
}
