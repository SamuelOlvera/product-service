package com.example.ecommerce.mapper;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.model.ProductResponse;

public class ProductMapper {

    public static ProductResponse toResponse(Product product, Integer stock) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                stock);

    }
}
