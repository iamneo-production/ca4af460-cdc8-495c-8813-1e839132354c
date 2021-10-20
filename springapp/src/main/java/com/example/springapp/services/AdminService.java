package com.example.springapp.services;

import com.example.springapp.models.OrderModel;
import com.example.springapp.models.ProductModel;
import com.example.springapp.repository.OrderRepository;
import com.example.springapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<ProductModel> getProduct() {
        return (List<ProductModel>) productRepository.findAll();
    }

    public void productSave(ProductModel data) {
        System.out.println("Service");
        productRepository.save(data);
    }



    public List<ProductModel> productEditData(String id) {
        Iterable<ProductModel> iterable =productRepository.findAllById(Collections.singleton(id));
        ArrayList<ProductModel> arrayList=new ArrayList<>();
        Iterator<ProductModel> it=iterable.iterator();
        while(it.hasNext())
        {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public void productEdit(ProductModel productModel, String id) {
        productRepository.save(productModel);
    }

    public List<OrderModel> getAllOrders() {
        Iterator<OrderModel> it=orderRepository.findAll().iterator();
        List<OrderModel> list=new ArrayList<>();
        it.forEachRemaining(list::add);
        return list;
    }

    public void productDelete(String id) {
        productRepository.deleteById(id);
    }
}
