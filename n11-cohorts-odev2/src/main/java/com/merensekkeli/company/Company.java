package com.merensekkeli.company;

import com.merensekkeli.invoice.Invoice;

import java.util.HashSet;
import java.util.Set;

public class Company {

    private String name;
    private String sector;
    private Set<Invoice> invoices;

    public Company(String name, String sector) {
        this.name = name;
        this.sector = sector;
        this.invoices = new HashSet<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
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
