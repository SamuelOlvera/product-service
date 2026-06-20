package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ecommerce.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    public List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoringCase(String name, String description);
}


