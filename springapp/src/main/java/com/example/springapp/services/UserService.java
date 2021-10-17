package com.example.springapp.services;

import com.example.springapp.models.LoginModel;
import com.example.springapp.models.ProductModel;
import com.example.springapp.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public boolean saveUser(UserModel user) {

        return false;
    }

    public boolean checkUser(LoginModel data) {
        return false;
    }

    public List<ProductModel> getHomeProducts() {
        return new ArrayList<ProductModel>();
    }


}
