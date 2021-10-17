package com.example.springapp.repository;

import com.example.springapp.models.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductModel,String> {

}
