package com.examly.spring.repository;

import com.examly.spring.model.CartModel;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartModel,Integer>{

	void deleteById(Integer cart_item_id);

}
