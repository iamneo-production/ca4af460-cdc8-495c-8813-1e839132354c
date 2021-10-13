package com.examly.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.ProductModel;
import com.examly.spring.services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
    ProductServices productServices;
	
	@GetMapping(value="/admin")
	public List<ProductModel> getProduct(){
		return productServices.getAllProducts();
	}
	
	@GetMapping(value="/home")
	public List<ProductModel> getHomeProduct(){
		return productServices.getAllProducts();
	}
	
	@GetMapping(value="/admin/productEdit/{id}")
	public  Optional<ProductModel> productEditData(@PathVariable int id) {
		return productServices.getProductById(id);
	}
	
	@PostMapping(value="/admin/productEdit/{id}")
	public void productEditSave(@RequestBody ProductModel product, @PathVariable int id){
		productServices.editSave(product,id);
	}
	
	@PostMapping(value="/admin/addProduct")
	public boolean productSave(@RequestBody ProductModel product){
		return productServices.saveProduct(product);
	}
	
	@PostMapping(value="/admin/delete/{id}")
	public void productDelete(@PathVariable int id){
		productServices.deleteProduct(id);
	}
}
