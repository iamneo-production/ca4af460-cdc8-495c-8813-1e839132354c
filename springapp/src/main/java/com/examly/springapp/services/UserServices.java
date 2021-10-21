package com.examly.spring.services;

import java.util.List;
import java.util.Optional;

import com.examly.spring.model.CartModel;
import com.examly.spring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.LoginModel;
import com.examly.spring.model.UserModel;
import com.examly.spring.repository.LoginRepository;
import com.examly.spring.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private LoginRepository loginRepository;

	@Autowired
	private CartRepository cartRepository;
		

	public List<UserModel> getAll(){
		return userRepository.findAll();
	}

	public Optional<UserModel> getUserById(int id) {
		return userRepository.findByUserId(id);
	}
	
	public boolean saveUserModel(UserModel user){
			String email=user.getEmail();
			String password=user.getPassword();
			String mobileNumber=user.getMobileNumber();
			if(!userRepository.existsByEmail(email) && !userRepository.existsByMobileNumber(mobileNumber)){
				CartModel cart = new CartModel();
				cart.setUser(user);
				user.setCart(cart);
				userRepository.save(user);
				LoginModel login = new LoginModel(email,password);
				loginRepository.save(login);
				return true;
			}
			return false;	
	}
}
