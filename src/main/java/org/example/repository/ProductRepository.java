package org.example.repository;

import org.example.mapper.dtos.ProductDto;

import java.util.List;

public interface ProductRepository {
    List<ProductDto> getAllProducts();
}
