package com.examly.spring.controller;

import java.util.List;

import com.examly.spring.model.CartProductModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.examly.spring.model.CartModel;
import com.examly.spring.services.CartServices;

@RestController
public class CartController {

	@Autowired
	CartServices cartServices;

	@PostMapping(value="/home/{user_id}")
	public boolean addToCart(
			@RequestParam("product_id") String product_id,
			@RequestParam("quantity") String Quantity,
			@PathVariable("user_id") int user_id
	){
		return cartServices.addProduct(product_id, Quantity, user_id);
	}
	
	@GetMapping("/cart/{user_id}")
	public List<CartProductModel> showCart(@PathVariable int user_id){
		return cartServices.getCartItems(user_id);
	}

	@PostMapping(value="/cart/delete/{user_id}")
	public void deleteCartItem(@RequestParam("product_id") int product_id,@PathVariable int user_id) {
		cartServices.deleteItem(user_id,product_id);
	}
}
