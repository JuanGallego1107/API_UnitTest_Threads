package org.example.repository.Impl;

import org.example.domain.models.Customer;
import org.example.domain.models.Order;
import org.example.domain.models.Product;
import org.example.mapper.dtos.OrderDto;
import org.example.mapper.mappers.CustomerMapper;
import org.example.mapper.mappers.OrderMapper;
import org.example.mapper.mappers.ProductMapper;
import org.example.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class orderRepositoryImpl implements OrderRepository {

    private List<Order> orders;
    private List<Product> products;
    private List<Customer> customers;
    public orderRepositoryImpl(){
        customerRepositoryImpl  customerRepo = new customerRepositoryImpl();
        productRepositoryImpl productRepo = new productRepositoryImpl();
        customers = CustomerMapper.mapFromDto(customerRepo.getAllCustomers());
        products = ProductMapper.mapFromDto(productRepo.getAllProducts());

        Order or1 = new Order(1L,"Processed", LocalDate.of(2021,2,15)
                ,LocalDate.now(),products.subList(0, 3), customers.get(0));
        Order or2 = new Order(2L,"Processed",LocalDate.of(2021,3,16)
                ,LocalDate.now(),products.subList(3, 4), customers.get(1));
        Order or3 = new Order(3L,"Processed",LocalDate.now(),LocalDate.now(),products.subList(3, 5), customers.get(4));
        Order or4 = new Order(4L,"Processed",LocalDate.of(2023,5,16)
                ,LocalDate.now(),products.subList(5, 7), customers.get(2));
        Order or5 = new Order(5L,"Processed",LocalDate.of(2023,6,26)
                ,LocalDate.now(),products.subList(7, 9), customers.get(3));
        Order or6 = new Order(6L,"Processed",LocalDate.of(2022,3,12)
                ,LocalDate.now(),products.subList(8, 10), customers.get(0));
        Order or7 = new Order(7L,"Processed",LocalDate.of(2022,3,12)
                ,LocalDate.now(),products.subList(4, 6), customers.get(1));

        orders = List.of(or1, or2, or3, or4, or5, or6,or7);

    }

    @Override
    public List<OrderDto> getAllOrders() {
        return OrderMapper.mapFrom(orders);
    }
}
