package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired private ProductRepository productRepository;

    @GetMapping(path = "/product")
    private Collection<Product> getProductollection(){
        return this.productRepository.findAll().stream().collect(Collectors.toList());
    }
}

