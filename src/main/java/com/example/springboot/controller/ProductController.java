package com.example.springboot.controller;

import com.example.springboot.model.Product;
import com.example.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{pId}")
    public Product getProductById(@PathVariable("pId") String pId){
        return productService.getProductById(pId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product p){
        productService.addProduct(p);
    }

    @PutMapping("/products/{pId}")
    public void updateProduct(@PathVariable("pId") String pId,@RequestBody Product p){
        productService.updateProduct(pId,p);
    }

    @DeleteMapping("/products/{pId}")
    public void deleteProduct(@PathVariable("pId") String pId){
        productService.deleteProduct(pId);
    }
}
