package org.example.mapper.mappers;

import org.example.domain.models.Customer;
import org.example.mapper.dtos.CustomerDto;

import java.util.List;

public class CustomerMapper {
    public static CustomerDto mapFrom(Customer source){
        return new CustomerDto(source.getId(),
                source.getName(),
                source.getTier());
    }

    public static Customer mapFrom(CustomerDto source){
        return new Customer(source.customerId(),
                source.customerName(),
                source.tier());
    }

    public static List<CustomerDto> mapFrom(List<Customer> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
    public static List<Customer> mapFromDto(List<CustomerDto> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
