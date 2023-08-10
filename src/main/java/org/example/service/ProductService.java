package org.example.service;

import org.example.domain.models.Product;
import org.example.mapper.dtos.ProductDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getProdFromCategorPrice();
    List<ProductDto> getProdFromCategoryApplyDiscount();
    ProductDto getCheapestProduct();
    Map<String, Optional<ProductDto>> getMostExpensiveProduct();

    String getCheapestProductThread();
    List<ProductDto> getProdFromCategoryApplyDiscountThread();
    void sleepThread(int millis);
}
