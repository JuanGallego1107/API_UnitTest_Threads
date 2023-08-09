package org.example.repository;

import org.example.mapper.dtos.CustomerDto;

import java.util.List;

public interface customerRepository {
    List<CustomerDto> getAllCustomers();
}
