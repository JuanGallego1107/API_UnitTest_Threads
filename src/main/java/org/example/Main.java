package org.example;

import org.example.service.OrderService;
import org.example.service.ProductService;
import org.example.service.impl.OrderServiceImpl;
import org.example.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    private static ProductService productService;
    private static OrderService orderService;

    public static void main(String[] args) {
        productService = new ProductServiceImpl();
        orderService = new OrderServiceImpl(productService);
        String opc = "1";
        Scanner x = new Scanner(System.in);
        System.out.println("Digita el numero para hacer una consulta:" +
                "\n Consultas -> " +
                " \n 1.Lista para categoria \"Libros\" y precio mayor a 100." +
                " \n 2. Lista de pedidos que contengan productos de categoria \"Bebé\"." +
                " \n 3. Lista para categoria \"Juguetes\" y descuento de 10%. " +
                " \n 4.Lista de productos pedidos por el cliente de tier 2 entre el 01 de febrero de 2021 y el 01 de abril de 2021." +
                " \n 5. Lista de los producto de categoria Libros mas baratos." +
                " \n 6. Lista de los 3 pedidos mas recientes (Por fecha de la orden."+
                " \n 7. Suma total de los pedidos realizado en una fecha especifica." +
                " \n 8. Promedio de pago en los pedidos en una fecha especifica."+
                " \n 9. Mapa de datos con registros de pedidos agrupados por cliente."+
                " \n 10. Producto mas caro por categoria."+
                " \n 11. Salir.");
        opc = x.next();

        switch (opc) {
            case "1" -> {
                System.out.println(productService.getProdFromCategorPrice());
            }
            case "2" -> {
                System.out.println(orderService.getOrdersByProducts());
            }
            case "3" -> {
                System.out.println(productService.getProdFromCategoryApplyDiscount());
            }
            case "4" -> {
                System.out.println(orderService.getProdByDateAndTier());
            }
            case "5" -> {
                System.out.println(productService.getCheapestProduct());
            }
            case "6" -> {
                System.out.println(orderService.getLatestOrders());
            }
            case "7" -> {
                System.out.println(orderService.getSumProductsByDate());
            }
            case "8" -> {
                System.out.println(orderService.getAvgProductsByDate());
            }
            case "9" -> {
                System.out.println(orderService.getOrderMapPerClient());
            }
            case "10" -> {
                System.out.println(productService.getMostExpensiveProduct());
            }
            case "11" -> {
                System.out.println("Hasta Pronto");
            }
            default -> {
                System.out.println("Ingresa un numero valido para consultar.");
            }
        }
    }
}