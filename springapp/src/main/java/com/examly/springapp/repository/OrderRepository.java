package com.examly.spring.repository;

import com.examly.spring.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel,Integer>{

    List<OrderModel> findAllByUserId(int userId);

}
