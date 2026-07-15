package com.example.springboot.service;

import com.example.springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<> ( Arrays.asList(
            new Product("P101","Monitor","Electronics"),
            new Product("P102","Blanket","Household"),
            new Product("P103","Laptop","Electronics"),
            new Product("P104","Shirt","Fashion"),
            new Product("P105","Pens","School")
    ));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public void updateProduct(String id,Product product){
        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            if(p.getId().equals(id)){
                products.set(i,product);
                return;
            }
        }
    }

    public void deleteProduct(String id){
        products.removeIf(p -> p.getId().equals(id));
    }
}
