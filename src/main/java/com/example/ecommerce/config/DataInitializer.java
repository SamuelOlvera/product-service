package com.example.ecommerce.config;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.mapper.ProductInputMapper;
import com.example.ecommerce.model.ProductInput;
import com.example.ecommerce.repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DataInitializer implements CommandLineRunner{

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;
    private final ProductInputMapper productInputMapper;

    public DataInitializer (ProductRepository productRepository, ObjectMapper objectMapper,
         ProductInputMapper productInputMapper){
            this.productRepository = productRepository;
            this.objectMapper = objectMapper;
            this.productInputMapper = productInputMapper;
         }

    @Override
    public void run (String...args) throws Exception{
        if (productRepository.count()>0) return;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("products-input.json"));

        List<ProductInput> inputs = objectMapper.readValue(inputStream, new TypeReference<List<ProductInput>>() {});

        List<Product> products = inputs.stream()
            .map(productInputMapper::toEntity)
            .toList();

        productRepository.saveAll(products);

    }

}
