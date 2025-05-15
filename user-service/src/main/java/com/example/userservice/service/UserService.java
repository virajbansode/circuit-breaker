package com.example.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.model.Product;
import com.example.userservice.model.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserService {

    private static final String PRODUCT_SERVICE = "product-service";

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "fallbackGetUserProducts")
    public User getAllUsers() {
        // Call the product service to get the list of products
         ResponseEntity<List<Product>> response = restTemplate.exchange(
            "http://localhost:9090/products",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Product>>() {}
        );
        List<Product> products = response.getBody(); 
        return new User("John Doe", products);
    }
    public User fallbackGetUserProducts(Exception e) {
        // Fallback logic when the product service is down
        System.out.println("Fallback method called: " + e.getMessage());
        return new User("Fallback User",  List.of(
            new Product(1, "Product 1", 10.0),
            new Product(2, "Product 2", 20.0)
        ));
    }
}
