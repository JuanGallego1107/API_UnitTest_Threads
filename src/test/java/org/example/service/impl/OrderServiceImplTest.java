package org.example.service.impl;

import org.example.domain.models.Order;
import org.example.mapper.dtos.OrderDto;
import org.example.service.impl.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OrderServiceImplTest {

    OrderServiceImpl orderService;
    ProductServiceImpl productService;
    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl();

        orderService = new OrderServiceImpl(productService);

    }

    @Test
    void getOrdersByProducts() {
        List<OrderDto> expectedOrders = Utils.getUserListSimulated();
        List<OrderDto> result = orderService.getOrdersByProducts();
        assertEquals(expectedOrders.size(), result.size(),"La funcion no se esta desarrollando correctamente.");
    }

    @Test
    void getLatestOrders() {
        List<OrderDto> expectedOrders = Utils.getUserListSimulated();
        List<OrderDto> result = orderService.getLatestOrders();
        assertEquals(expectedOrders.size(), result.size(),"La funcion no se esta desarrollando correctamente.");
    }

}