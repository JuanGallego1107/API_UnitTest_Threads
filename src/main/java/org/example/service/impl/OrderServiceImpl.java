package org.example.service.impl;

import org.example.domain.models.Customer;
import org.example.domain.models.Product;
import org.example.mapper.dtos.CustomerDto;
import org.example.mapper.dtos.OrderDto;
import org.example.mapper.dtos.ProductDto;
import org.example.repository.Impl.orderRepositoryImpl;
import org.example.repository.Impl.productRepositoryImpl;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.service.OrderService;
import org.example.service.ProductService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    List<OrderDto> orders;
    List<ProductDto> products;

    private OrderRepository repository;
    public OrderServiceImpl(ProductService productService){
        OrderRepository repo = new orderRepositoryImpl();
        ProductRepository rep = new productRepositoryImpl();
        products = rep.getAllProducts();
        orders = repo.getAllOrders();
    }
    @Override
    public List<OrderDto> getOrdersByProducts() {
        return orders.stream()
                .filter(e -> e.products().stream()
                        .anyMatch(prod -> prod.getCategory().equalsIgnoreCase("Bebé")))
                .toList();
    }

    @Override
    public List<OrderDto> getLatestOrders() {
        return orders.stream()
                .sorted(Comparator.comparing(OrderDto::orderDate).reversed())
                .limit(3)
                .toList();
    }

    @Override
    public Double getSumProductsByDate() {
        List<OrderDto> orderSpecificDate = orders.stream()
                .filter(e -> e.orderDate().getMonthValue() == 3)
                .filter(e -> e.orderDate().getYear() == 2022)
                .toList();

        return orderSpecificDate.stream()
                .mapToDouble(e -> e.products().stream().mapToDouble(Product::getPrice)
                        .sum())
                .sum();

    }

    @Override
    public Double getAvgProductsByDate() {
        List<OrderDto> listSpecificDate = orders.stream()
                .filter(e -> Objects.equals(e.orderDate(), LocalDate.of(2022, 3, 12)))
                .toList();

        return listSpecificDate.stream()
                .mapToDouble(e -> e.products().stream().mapToDouble(Product::getPrice).
                        average().orElse(0.0))
                .average().orElse(0.0);
    }

    @Override
    public Map<Customer, List<OrderDto>> getOrderMapPerClient() {
        return orders.stream()
                .collect(Collectors.groupingBy(OrderDto::customer));
    }

    @Override
    public List<ProductDto> getProdByDateAndTier() {
        return orders.stream()
                .filter(e -> e.customer().getTier() == 2)
                .filter(e -> e.orderDate().isAfter(LocalDate.of(2021, 2, 1)))
                .filter(e -> e.orderDate().isBefore(LocalDate.of(2021, 4, 1)))
                .flatMap(e -> e.products().stream())
                .distinct()
                .map(product -> new ProductDto(product.getId(), product.getName(),product.getCategory(),product.getPrice()))
                .toList();
    }



    @Override
    public Double getSumProductsByDateThread() {
        sleepThread(2000);
        launchException();
        return getSumProductsByDate();
    }

    private void launchException() {
        throw  new RuntimeException("Could not launch");
    }

    @Override
    public void sleepThread(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Double getAvgProductsByDateThread() {
        sleepThread(2000);
        return getAvgProductsByDate();
    }
}

