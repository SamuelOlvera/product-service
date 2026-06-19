package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.ProductResponse;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> getProducts (@RequestParam String query){

            List<ProductResponse> productList = productService.searchProducts(query);

            return ResponseEntity.ok(productList);
    }

}
