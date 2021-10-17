package com.example.springapp.controllers;

import com.example.springapp.models.OrderModel;
import com.example.springapp.models.ProductModel;
import com.example.springapp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/admin")
    public List<ProductModel> getProduct()
    {
        return adminService.getProduct();
    }

    @PostMapping("/admin/addProduct")
    public void productSave(@RequestBody ProductModel data)
    {
        System.out.println("Controller");
        adminService.productSave(data);
    }

    @GetMapping("/admin/delete/{id}")
    public void productDelete(@PathVariable String id)
    {
        adminService.productDelete(id);
    }

    @GetMapping("/admin/productEdit/{id}")
    // Returns all the product with {id}
    public List<ProductModel> productEditData(@PathVariable String id)
    {
        return adminService.productEditData(id);
    }

    @PostMapping("/admin/productEdit/{id}")
    public void productEditSave(@RequestBody ProductModel productModel,@PathVariable String id)
    {
        adminService.productEdit(productModel,id);
    }

    @GetMapping("/admin/orders")
    public List<OrderModel> getAllOrders()
    {

        // API Endpoints last one in admin | NOT PRESENT in Controllers
        return adminService.getAllOrders();
    }


}
@RestController
class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "There is some error. Please try again";
    }
}
