package com.examly.spring.services;

import java.util.List;

import com.examly.spring.model.CartModel;
import com.examly.spring.model.CartProductModel;
import com.examly.spring.model.ProductModel;
import com.examly.spring.repository.OrderRepository;
import com.examly.spring.repository.ProductRepository;
import com.examly.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.OrderModel;

@Service
public class OrderServices {

	@Autowired
	ProductServices productServices;

	@Autowired
	CartServices cartServices;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserServices userServices;

	public void saveOrder(int userId) {
		CartModel cart = userServices.getUserById(userId).get().getCart();
		List<CartProductModel> products = cart.getCartProductModel();
		products.forEach(product -> orderPlace(userId, product.getProduct(), product.getQuantity()));
		cartServices.flush(cart);
	}

	public void orderPlace(int userId, int productId, int quantity) {
		OrderModel orderModel = new OrderModel();
		ProductModel product = productServices.getProductByProductId(productId);
		product.setQuantity(String.valueOf(Integer.parseInt(product.getQuantity()) - quantity));
		orderModel.setUserId(userId)
				.setProductName(product.getProductName())
				.setStatus("placed")
				.setQuantity(quantity)
				.setPrice(product.getPrice())
				.setTotalPrice(String.valueOf(Integer.parseInt(product.getPrice())*quantity));
		orderRepository.save(orderModel);
		productRepository.save(product);
	}

	public void orderPlace(int userId, int productId) {
		orderPlace(userId, productId, 1);
	}

	public List<OrderModel> showOrders(int userId) {
		return orderRepository.findAllByUserId(userId);
	}

	public List<OrderModel> showAllOrders() {
		return orderRepository.findAll();
	}
}
