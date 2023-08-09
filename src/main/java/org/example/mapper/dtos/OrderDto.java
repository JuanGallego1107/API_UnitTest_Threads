package org.example.mapper.dtos;

import org.example.domain.models.Customer;
import org.example.domain.models.Product;

import java.time.LocalDate;
import java.util.List;

public record OrderDto (Long orderId,
                        String status,
                        LocalDate orderDate,
                        LocalDate deliveryDate,
                        List<Product> products,
                        Customer customer) {
}
