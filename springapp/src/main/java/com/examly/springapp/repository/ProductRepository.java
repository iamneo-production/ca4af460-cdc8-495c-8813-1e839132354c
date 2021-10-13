package com.examly.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.examly.spring.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel,Integer>,CrudRepository<ProductModel,Integer> {

	boolean existsByProductId(int productId);

	ProductModel findByProductId(int productId);

    ProductModel getProductByProductId(int productId);
}
