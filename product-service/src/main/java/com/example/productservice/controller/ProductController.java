package com.example.productservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.model.Product;

@RestController
public class ProductController {


     @GetMapping("/products")
     public List<Product> getAllProducts() {
         return List.of(
             new Product(1, "Product 1", 100.0),
             new Product(2, "Product 2", 200.0),
             new Product(3, "Product 3", 300.0)
         );
     }

}
