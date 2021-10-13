package com.examly.spring.services;

import com.examly.spring.model.CartModel;
import com.examly.spring.model.CartProductModel;
import com.examly.spring.model.ProductModel;
import com.examly.spring.repository.CartProductRepository;
import com.examly.spring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartProductServices {
    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private CartRepository cartRepository;

    public void saveCartProduct(CartProductModel cartProductModel)
    {
        cartProductRepository.save(cartProductModel);
    }

    public CartProductModel findByProductCart(ProductModel product, CartModel cart) {
        CartProductModel cartProductModel = cartProductRepository.findByProductAndCart(product,cart);
        return cartProductModel;
    }

    public boolean existsProductCart(ProductModel product, CartModel cart){
        return cartProductRepository.existsByProductAndCart(product,cart);
    }

    public List<CartProductModel> findByCartId(CartModel cartId) {
        return cartProductRepository.findAllByCart(cartId);
    }

    public CartProductModel findByCartAndProduct(CartModel cartModel, ProductModel productModel) {
        return cartProductRepository.findByCartAndProduct(cartModel,productModel);
    }

    public void removeProduct(CartModel cartModel, int cartProductId) {
        List<CartProductModel> cartProductModelList = cartModel.getCartProductModel();
        cartProductModelList.removeIf(c -> c.getId().equals(cartProductId));
        cartModel.setCartProductModel(cartProductModelList);
        cartRepository.save(cartModel);
        cartProductRepository.deleteById(cartProductId);
    }


}
