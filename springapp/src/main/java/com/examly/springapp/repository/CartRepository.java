package com.examly.spring.repository;

import com.examly.spring.model.CartModel;

//import java.util.List;

import com.examly.spring.model.ProductModel;
import com.examly.spring.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public interface CartRepository extends JpaRepository<CartModel,Integer>{

	void deleteById(Integer cart_item_id);

}
