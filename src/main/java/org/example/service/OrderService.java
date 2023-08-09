package org.example.service;

import org.example.domain.models.Customer;
import org.example.domain.models.Order;
import org.example.mapper.dtos.CustomerDto;
import org.example.mapper.dtos.OrderDto;
import org.example.mapper.dtos.ProductDto;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderDto> getOrdersByProducts();
    List<OrderDto> getLatestOrders();
    Double getSumProductsByDate();
    Double getAvgProductsByDate();
    Map<Customer,List<OrderDto>> getOrderMapPerClient();
    List<ProductDto> getProdByDateAndTier();
}
