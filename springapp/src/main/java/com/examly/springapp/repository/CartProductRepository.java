package com.examly.spring.repository;

import com.examly.spring.model.CartModel;
import com.examly.spring.model.CartProductModel;
import com.examly.spring.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductModel,Integer> {

    boolean existsByProductAndCart(ProductModel product,CartModel cart);

    CartProductModel findByProductAndCart(ProductModel product, CartModel cart);

    CartProductModel findByCartAndProduct(CartModel cart,ProductModel product);

    List<CartProductModel> findAllByCart(CartModel cartId);

}
