package org.example.mapper.mappers;

import org.example.domain.models.Order;
import org.example.domain.models.Product;
import org.example.mapper.dtos.OrderDto;
import org.example.mapper.dtos.ProductDto;

import java.util.List;

public class OrderMapper {
    public static OrderDto mapFrom(Order source){
        return new OrderDto(source.getId(),
                source.getStatus(),
                source.getOrderDate(),
                source.getDeliveryDate(),
                source.getProducts(),
                source.getCustomer());
    }

    public static Order mapFrom(OrderDto source){
        return new Order(source.orderId(),
                source.status(),
                source.orderDate(),
                source.deliveryDate(),
                source.products(),
                source.customer());
    }
    public static List<OrderDto> mapFrom(List<Order> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
