package org.example.service.impl;

import org.example.domain.models.Product;
import org.example.mapper.dtos.OrderDto;
import org.example.mapper.dtos.ProductDto;
import org.example.mapper.mappers.OrderMapper;
import org.example.repository.Impl.productRepositoryImpl;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    List<ProductDto> products;
    List<OrderDto> orders;

    public ProductServiceImpl() {
        ProductRepository repo = new productRepositoryImpl();
        products = repo.getAllProducts();
    }

    @Override
    public List<ProductDto> getProdFromCategorPrice() {
        return products.stream()
                .filter(e -> e.productCategory().equalsIgnoreCase("Libros"))
                .filter(e -> e.price() > 100)
                .toList();
    }

    @Override
    public List<ProductDto> getProdFromCategoryApplyDiscount() {
        return products.stream()
                .filter(e -> e.productCategory().equalsIgnoreCase("Juguetes"))
                .map(dis -> {
                    double discountedPrice = dis.price() * 0.10;
                    return new ProductDto(dis.productId(),dis.productName(), dis.productCategory(), dis.price() - discountedPrice);
                })
                .toList();
    }

    @Override
    public ProductDto getCheapestProduct() {
        return products.stream()
                .filter(e -> e.productCategory().equalsIgnoreCase("Libros"))
                .min(Comparator.comparing(ProductDto::price)).orElse(null);
    }

    @Override
    public Map<String, Optional<ProductDto>> getMostExpensiveProduct() {
        return products.stream()
                .collect(Collectors.groupingBy(ProductDto::productCategory,Collectors.
                        maxBy(Comparator.comparing(ProductDto::price))));
    }


    @Override
    public String getCheapestProductThread(){
        sleepThread(3000);
        return "¡Hilo terminado! "+getCheapestProduct();
    }

    @Override
    public List<ProductDto> getProdFromCategoryApplyDiscountThread() {
        sleepThread(5000);
        return getProdFromCategoryApplyDiscount();
    }

    public void sleepThread(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }



