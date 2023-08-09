package org.example.mapper.dtos;

public record CustomerDto (
        Long customerId,
        String customerName,
        Integer tier){

}
