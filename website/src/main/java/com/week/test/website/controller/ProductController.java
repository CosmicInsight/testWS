package com.week.test.website.controller;

import com.week.test.website.model.Product;
import com.week.test.website.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j

public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("allProducts")
    public List<Product> getAllproducts(){
        return productRepository.findAll();
    }
    @PostMapping("addProduct")
    public ResponseEntity<String> addProduct(@RequestParam("productName") String productName, @RequestParam("productStock") Integer productStock){
        Product product =  new Product();
        try {
            product.setProductName(productName);
            product.setProductStock(11);
            productRepository.save(product);
            return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
        }catch (Exception e) {return new ResponseEntity<>("Error :( ", HttpStatus.BAD_GATEWAY);}
    }
    @GetMapping("getProduct")
    public Product getproduct(@RequestParam("productId") Integer productId) throws ChangeSetPersister.NotFoundException {
        return productRepository.findById(productId).isPresent()? productRepository.findById(productId).get() : null;
    }
}
