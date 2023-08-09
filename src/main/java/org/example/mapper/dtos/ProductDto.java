package org.example.mapper.dtos;

public record ProductDto (Long productId,
                          String productName,
                          String productCategory,
                          Double price) {
}
