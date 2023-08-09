package org.example.repository.Impl;

import org.example.domain.models.Product;
import org.example.mapper.dtos.ProductDto;
import org.example.mapper.mappers.ProductMapper;
import org.example.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class productRepositoryImpl implements ProductRepository {
    List<Product> products;

    public productRepositoryImpl (){
        Product product1 = new Product(1L,"Libro1","Libros",30.0);
        Product product2 = new Product(2L,"Libro2","Libros",120.0);
        Product product3 = new Product(3L,"Libro3","Libros",110.0);
        Product product4 = new Product(4L,"Fabula1","Fabula",30.0);
        Product product5 = new Product(5L,"Babero","Bebé",10.000);
        Product product6 = new Product(6L,"Mameluco","Bebé",25.000);
        Product product7 = new Product(7L,"Carro Hot Wheels","Juguetes",35.0);
        Product product8 = new Product(8L,"Max steel","Juguetes",43.0);
        Product product9 = new Product(9L,"Libro4","Libros",315.0);
        Product product10 = new Product(10L,"Libro5","Libros",45.0);

        products = List.of(product1,product2,product3,product4,product5,product6,product7,product8,product9,product10);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return ProductMapper.mapFrom(products);
    }
}
