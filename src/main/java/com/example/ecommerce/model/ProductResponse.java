package com.example.ecommerce.model;

import java.math.BigDecimal;

public record ProductResponse (

    String id, 
    String name,
    String description,
    BigDecimal price,
    Integer stock
){}
