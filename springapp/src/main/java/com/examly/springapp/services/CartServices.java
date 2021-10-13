package com.examly.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.examly.spring.model.CartProductModel;
import com.examly.spring.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.CartModel;
import com.examly.spring.repository.CartRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartServices {
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	ProductServices productServices;

	@Autowired
	private UserServices userServices;

	@Autowired
	private CartProductServices cartProductServices;

	public boolean addProduct(ProductModel product, CartModel cart, int Quantity){
		if(Integer.parseInt(product.getQuantity()) >= Quantity){
			cart.setPrice(String.valueOf(Integer.parseInt(cart.getPrice()) + Integer.parseInt(product.getPrice())*Quantity));
			cart.setQuantity(cart.getQuantity()+Quantity);

			CartProductModel cartProductModel;
			if(!cartProductServices.existsProductCart(product,cart)){
				cartProductModel= new CartProductModel();
				cartProductModel.setProduct(product)
								.setCart(cart)
								.setQuantity(Quantity);
			}
			else{
				cartProductModel = cartProductServices.findByProductCart(product,cart);
				cartProductModel.setQuantity(cartProductModel.getQuantity()+Quantity);
			}
			cartProductServices.saveCartProduct(cartProductModel);

			cartRepository.save(cart);
			return true;
		}
		else
			return false;
	}

	public boolean addProduct(String product_id,String Quantity, int user_id){
		ProductModel product;
		CartModel cart;

		try {
			product = productServices.getProductById(Integer.parseInt(product_id)).get();
			cart = userServices.getUserById(user_id).get().getCart();
			return addProduct(product, cart, Integer.parseInt(Quantity));
		}
		catch(Exception e){
			System.out.println("No product or user found for given id"+e);
			return false;
		}
	}


	public List<CartProductModel> getCartItems(int userId) {

		CartModel cartModel = userServices.getUserById(userId).get().getCart();
		return cartProductServices.findByCartId(cartModel);
	}

	public void deleteItem(int userId,int productId) {
		CartModel cartModel = userServices.getUserById(userId).get().getCart();
		ProductModel productModel = productServices.getProductByProductId(productId);

		CartProductModel cartProductModel = cartProductServices.findByCartAndProduct(cartModel,productModel);

		int cartProductId = cartProductModel.getId();

		cartProductServices.removeProduct(cartModel,cartProductId);
	}

}
	

