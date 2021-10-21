package com.examly.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.LoginModel;
import com.examly.spring.services.LoginServices;

@RestController
public class LoginController {
	
	@Autowired
    LoginServices loginServices;
	
	@PostMapping(value="/login")
	boolean checkUser(@RequestBody LoginModel data) {
		return loginServices.checkUserModel(data);
	}
}
