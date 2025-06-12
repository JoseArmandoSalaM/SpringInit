package com.springinit.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springinit.di.factura.springboot_difactura.models.Client;
import com.springinit.di.factura.springboot_difactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show() {
        Invoice i = new Invoice();
        Client c = new Client();
        c.setLastname(invoice.getCliente().getLastname());
        c.setName(invoice.getCliente().getName());
        i.setCliente(c);
        i.setDescripcion(invoice.getDescripcion());
        i.setItem(invoice.getItem());
        return i;
    }

}
