package org.example;

import org.example.service.OrderService;
import org.example.service.ProductService;
import org.example.service.impl.OrderServiceImpl;
import org.example.service.impl.ProductServiceImpl;

import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

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
                " \n 11. Implementacion runAsync."+
                " \n 12. Implementacion supplyAsync. "+
                " \n 13. Implementacion thenAccept. "+
                " \n 14. Implementacion thenApply y exceptionally."+
                " \n 15. Implementacion thenRun."+
                " \n 16. Salir.");
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
                CompletableFuture.runAsync(()-> System.out.println(productService.getCheapestProductThread()));
                productService.sleepThread(6000);
                System.out.println("¡Hilo Principal terminado!");
            }
            case "12"-> {
                System.out.println(CompletableFuture.supplyAsync(()-> productService.getProdFromCategoryApplyDiscountThread()).join());
            }
            case "13"-> {
                CompletableFuture.supplyAsync(()-> productService.getCheapestProductThread())
                        .thenAccept(System.out::println);
                productService.sleepThread(8000);
            }
            case "14" -> {
                CompletableFuture.supplyAsync(()-> orderService.getSumProductsByDateThread())
                        .thenApply(result -> result+ orderService.getAvgProductsByDate())
                        .exceptionally(error -> 0.0)
                        .thenAccept(System.out::println);
                orderService.sleepThread(5000);
            }
            case "15" -> {
                CompletableFuture.supplyAsync(()-> orderService.getAvgProductsByDateThread())
                        .thenAccept(System.out::println)
                        .thenRun(()-> System.out.println(productService.getCheapestProductThread()));
                orderService.sleepThread(7000);
            }
            case "16" -> {
                System.out.println("Vuelve Pronto");
            }
            default -> {
                System.out.println("Ingresa un numero valido para consultar.");
            }
        }
    }
}