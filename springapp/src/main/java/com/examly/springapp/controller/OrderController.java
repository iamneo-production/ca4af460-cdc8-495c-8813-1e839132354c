package com.examly.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.OrderModel;
import com.examly.spring.services.OrderServices;
@RestController
public class OrderController {

	@Autowired
	OrderServices orderModelServices;

	@GetMapping("/orders")
	List<OrderModel> getUserProducts(String id){
		return null;
	}

	void saveProduct(String id) {

	}
    @PostMapping("/placeOrder")
	void placeOrder(OrderModel order) {

	}
}
