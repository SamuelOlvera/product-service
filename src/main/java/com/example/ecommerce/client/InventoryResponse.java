package com.example.ecommerce.client;

public record InventoryResponse(
    String productId,

    int stock
) {}
