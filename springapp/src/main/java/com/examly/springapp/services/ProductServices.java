package com.examly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.ProductModel;
import com.examly.spring.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
    ProductRepository productRepository;

	@Autowired
	CartServices cartServices;

	public List<ProductModel> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<ProductModel> getProductById(int id) {
		return productRepository.findById(id);
	}

	public void editSave(ProductModel product, int id) {
		ProductModel pr = productRepository.findByProductId(id);
		pr.setDescription(product.getDescription());
		pr.setImageUrl(product.getImageUrl());
		pr.setPrice(product.getPrice());
		pr.setProductName(product.getProductName());
		productRepository.save(pr);
	}

	public boolean saveProduct(ProductModel product) {
		int productId = product.getProductId();
		if(!productRepository.existsByProductId(productId)) {
			productRepository.save(product);
			return true;
		}
		return false;
	}

	public void deleteProduct(ProductModel product) {
		try{
			cartServices.getAllCarts().forEach(cart -> cartServices.deleteItem(cart, product));
			productRepository.deleteById(product.getProductId());
		}
		catch (Exception e){
			System.out.print("Product with this product id does not exist\n" + e);
		}
	}

	public void deleteProduct(int id) {
		deleteProduct(getProductByProductId(id));
	}

    public ProductModel getProductByProductId(int productId) {
		return productRepository.getProductByProductId(productId);
    }
}
