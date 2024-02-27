package com.merensekkeli;

import com.merensekkeli.company.Company;
import com.merensekkeli.customer.Customer;
import com.merensekkeli.invoice.Invoice;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {
    private List<Customer> customers;
    private List<Invoice> invoices;
    private List<Company> companies;

    public TestDataGenerator() {
        customers = new ArrayList<>();
        invoices = new ArrayList<>();
        companies = new ArrayList<>();
        generateData();
    }

    private void generateData() {
        Company company1 = new Company("Tech Innovations", "Technology");
        Company company2 = new Company("Green Foods", "Food");
        Company company3 = new Company("Great Books", "Books");
        companies.add(company1);
        companies.add(company2);
        companies.add(company3);

        Customer customer1 = new Customer(1L, "Alice", "alice@mail.com", LocalDate.of(2023, Month.JUNE, 15));
        Customer customer2 = new Customer(2L, "Bob", "bob@mail.com", LocalDate.of(2023, Month.JANUARY, 10));
        Customer customer3 = new Customer(3L, "Carol", "carol@mail.com", LocalDate.of(2023, Month.JUNE, 20));
        Customer customer4 = new Customer(4L, "David", "davi@mail.com", LocalDate.of(2023, Month.JUNE, 25));
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        invoices.add(new Invoice("INV-100", 1200, LocalDate.of(2023, Month.JUNE, 15), customer1, company1));
        invoices.add(new Invoice("INV-101", 1600, LocalDate.of(2023, Month.JUNE, 25), customer3, company2));
        invoices.add(new Invoice("INV-102", 450, LocalDate.of(2023, Month.JANUARY, 5), customer2, company1));
        invoices.add(new Invoice("INV-103", 2000, LocalDate.of(2023, Month.DECEMBER, 1), customer1, company2));
        invoices.add(new Invoice("INV-104", 400, LocalDate.of(2023, Month.JUNE, 20), customer4, company3));

        company1.addInvoice(invoices.get(0));
        company1.addInvoice(invoices.get(2));
        company2.addInvoice(invoices.get(1));
        company2.addInvoice(invoices.get(3));
        company3.addInvoice(invoices.get(4));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
