package org.example.repository.Impl;

import org.example.domain.models.Customer;
import org.example.mapper.dtos.CustomerDto;
import org.example.mapper.mappers.CustomerMapper;
import org.example.repository.customerRepository;

import java.util.ArrayList;
import java.util.List;

public class customerRepositoryImpl implements customerRepository {

    List<Customer> customers;
    public customerRepositoryImpl(){

            Customer c1 = new Customer(1L, "Mario", 1);
            Customer c2 = new Customer(2L, "Juan", 2);
            Customer c3 = new Customer(3L, "Pablo", 3);
            Customer c4 = new Customer(4L, "Daniel",1);
            Customer c5 = new Customer(5L, "Camilo",2);

            customers = List.of(c1, c2, c3, c4, c5);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return CustomerMapper.mapFrom(customers);
    }
}
