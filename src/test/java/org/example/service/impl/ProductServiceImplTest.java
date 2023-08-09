package org.example.service.impl;

import org.example.mapper.dtos.OrderDto;
import org.example.mapper.dtos.ProductDto;
import org.example.service.impl.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceImplTest {
    @Test
    void getProdFromCategorPrice(){
        ProductServiceImpl productService = new ProductServiceImpl();
        List<OrderDto> expected = Utils.getUserListSimulated();
        List<ProductDto> result = productService.getProdFromCategorPrice();
        assertEquals(expected.size(), result.size(),"Esta funcion no esta desarrollandose de forma correcta");
    }
}