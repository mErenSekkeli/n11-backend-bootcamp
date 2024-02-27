package com.merensekkeli.invoice;

import com.merensekkeli.company.Company;
import com.merensekkeli.customer.Customer;

import java.time.LocalDate;

public class Invoice {

    private final String invoiceNumber;
    private double totalAmount;
    private LocalDate dueDate;
    private Customer customer;
    private Company company;

    public Invoice(String invoiceNumber, double totalAmount, LocalDate dueDate, Customer customer, Company company) {
        this.invoiceNumber = invoiceNumber;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
        this.customer = customer;
        this.company = company;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getDate() {
        return dueDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Company getCompany() {
        return company;
    }
}
