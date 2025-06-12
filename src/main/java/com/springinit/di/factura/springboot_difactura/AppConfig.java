package com.springinit.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.springinit.di.factura.springboot_difactura.models.Item;
import com.springinit.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value = "classpath:text.properties", encoding = "UTF-8")
public class AppConfig {

    // asi se le cambia el nombre @Bean("default")
    @Bean()
    List<Item> itemsInvoice() {
        Product p1 = new Product("Mouse", 500);
        Product p2 = new Product("Cartera", 200);
        Product p3 = new Product("Monitor", 100);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 5), new Item(p3, 4));

    }

    @Bean
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Mouse", 500);
        Product p2 = new Product("Silla", 200);
        Product p3 = new Product("Monitor", 100);
        Product p4 = new Product("Esritorio", 200);
        Product p5 = new Product("Impresora", 100);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 5), new Item(p3, 4), new Item(p4, 5), new Item(p5, 6));

    }
}
