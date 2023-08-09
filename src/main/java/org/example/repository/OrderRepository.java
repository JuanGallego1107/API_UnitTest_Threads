package org.example.repository;

import org.example.mapper.dtos.OrderDto;

import java.util.List;

public interface OrderRepository {
    List<OrderDto> getAllOrders();
}
