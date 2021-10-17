package com.example.springapp.repository;

import com.example.springapp.models.OrderModel;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderModel,String> {
}
