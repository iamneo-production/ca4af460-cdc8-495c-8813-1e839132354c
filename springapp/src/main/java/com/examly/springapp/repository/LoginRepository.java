package com.examly.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.spring.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel,String>{

	boolean existsByEmailAndPassword(String email, String password);
}
