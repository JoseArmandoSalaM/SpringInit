package com.springinit.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
// @JsonIgnoreProperties({ "targetSource", "advisors" })
public class Invoice {

    @Autowired
    private Client cliente;

    @Value("${invoice.office}")
    private String descripcion;

    @Autowired
    @Qualifier("itemsInvoiceOffice")
    private List<Item> item;

    // Si se quiere utilizar los valores que tiene los objetos de la clase no tienen
    // valor
    public Invoice() {
        System.out.println("Creando el componente factura");
        System.out.println(cliente);
        System.out.println(descripcion);
        System.out.println(item);
    }

    // Se ejecuta despues de instanciar los valores usar postconstruct para usar
    // despues de que se construya
    @PostConstruct
    public void init() {
        System.out.println(" Creando el componente factura");
        cliente.setName(cliente.getName().concat(" Armando Saa"));
        descripcion = descripcion.concat(" Factura de cliente: ")
                .concat(cliente.getName().concat(" ").concat(cliente.getLastname()));
    }

    // Antes de destruir si queremos cerrar un recurso usamos predestroy
    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente o bean invoice");
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public int getTotal() {
        // int total = 0;
        // for (Item ite : item) {
        // total += ite.getImporte();
        // }

        int total = item.stream()
                .map(item -> item.getImporte())
                .reduce(0, (sum, importe) -> sum + importe);

        return total;
    }

}
