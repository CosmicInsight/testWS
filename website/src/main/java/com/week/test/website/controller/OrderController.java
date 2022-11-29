package com.week.test.website.controller;

import com.week.test.website.model.Orders;
import com.week.test.website.model.Product;
import com.week.test.website.repository.OrdersRepository;
import com.week.test.website.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class OrderController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("allOrders")
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }
    @PostMapping("addOrder")
    public ResponseEntity<String> addOrder(@RequestParam("productId") Integer productId, @RequestParam("orderQuantity") Integer orderQuantity){
        Orders orders =  new Orders();
        try {
            orders.setOrderQuantity(orderQuantity);
            orders.setProduct(productRepository.findById(productId).get());
            ordersRepository.save(orders);
            return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
        }catch (Exception e) {return new ResponseEntity<>("Error :( ", HttpStatus.BAD_GATEWAY);}
    }
    @GetMapping("getOrder")
    public Orders getOrder(@RequestParam("orderId") Integer orderId) throws ChangeSetPersister.NotFoundException {
        return ordersRepository.findById(orderId).isPresent()? ordersRepository.findById(orderId).get() : null;
    }
}
