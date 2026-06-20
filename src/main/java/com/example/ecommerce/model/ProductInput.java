package com.example.ecommerce.model;

public record ProductInput (
    
    String Id,
    String title,
    String description,
    String price,
    String currency,
    String category,
    boolean active

){}
