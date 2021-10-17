package com.example.springapp.controllers;

import com.example.springapp.models.LoginModel;
import com.example.springapp.models.ProductModel;
import com.example.springapp.models.UserModel;
import com.example.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST,value="/signup")
    public boolean saveUser(UserModel user)
    {
        return userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public boolean checkUser(LoginModel data)
    {
        return userService.checkUser(data);
    }

    @GetMapping("/home")
    public List<ProductModel> getHomeProducts()
    {
        return userService.getHomeProducts();
    }

    @PostMapping("/home/{id}")
    public void addToCart(@PathVariable String id)
    {
        //Product ID | Required quantity of the product
        addToCart(id);
    }



}
