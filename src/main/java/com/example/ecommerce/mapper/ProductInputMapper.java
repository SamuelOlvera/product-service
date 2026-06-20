package com.example.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.model.ProductInput;

@Mapper(componentModel = "spring")
public interface ProductInputMapper {

    @Mapping(source = "title", target = "name")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "price", expression = "java(new java.math.BigDecimal(dto.price()))")
    Product toEntity (ProductInput dto);
}
