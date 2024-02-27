package com.merensekkeli.company;

import com.merensekkeli.invoice.Invoice;

import java.util.HashSet;
import java.util.Set;

public class Company {

    private final Long id;
    private String name;
    private String sector;
    private Set<Invoice> invoices;

    public Company(Long id, String name, String sector) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.invoices = new HashSet<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

}
