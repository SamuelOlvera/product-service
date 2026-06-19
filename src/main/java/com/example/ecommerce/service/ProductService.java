package com.example.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.client.InventoryClient;
import com.example.ecommerce.client.InventoryResponse;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.model.ProductResponse;
import com.example.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final InventoryClient inventoryClient;

    public ProductService (ProductRepository productRepository, InventoryClient inventoryClient){
        this.productRepository = productRepository;
        this.inventoryClient = inventoryClient;
    }
    
    public List<ProductResponse> searchProducts(String criteria){
        List<Product> productList = productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoringCase(criteria, criteria);
        if (productList.isEmpty()) return List.of();

        return productList.stream()
            .map(product -> {
                Integer stock = getStock(product.getId());
                return ProductMapper.toResponse(product, stock);
            }).toList();
    }

    public Integer getStock (String productId){
        try{
            InventoryResponse inventoryResponse = inventoryClient.getInventory(productId);
            return inventoryResponse.stock();
        }catch (Exception e){
            return null;
        }
    }


}
