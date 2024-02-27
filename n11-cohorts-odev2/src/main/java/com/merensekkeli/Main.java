package com.merensekkeli;

import com.merensekkeli.company.Company;
import com.merensekkeli.customer.Customer;
import com.merensekkeli.customer.CustomerManager;
import com.merensekkeli.invoice.Invoice;
import com.merensekkeli.invoice.InvoiceManager;

import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TestDataGenerator testDataGenerator = new TestDataGenerator();

        List<Customer> customers = testDataGenerator.getCustomers();
        List<Invoice> invoices = testDataGenerator.getInvoices();
        List<Company> companies = testDataGenerator.getCompanies();

        CustomerManager customerManager = new CustomerManager();

        customerManager.addCustomer(customers);
        InvoiceManager.addInvoices(invoices);
        InvoiceManager.addCompanies(companies);

        System.out.println("All Customers:");
        customerManager.listAllCustomers().forEach(customer -> System.out.println(customer.getName()));

        System.out.println("\nCustomers with the letter c in their names:");
        customerManager.listCustomersWithLetterContains('C').forEach(customer -> System.out.println(customer.getName()));

        System.out.println("\nTotal amount of invoices of registered customers in June:");
        System.out.println(InvoiceManager.getTotalAmountForCustomersRegisteredInAMonth(Month.JUNE));

        System.out.println("\nAll Invoices in the System:");
        InvoiceManager.listAllInvoices().forEach(invoice ->
                System.out.println("Invoice Number: " + invoice.getInvoiceNumber() + ", "
                        + "Amount: " + invoice.getTotalAmount() + ", "
                        + "Invoice Date: " + invoice.getDate() + ", "
                        + "Invoice Owner: " + invoice.getCustomer().getName() + ", "
                        + "Company: " + invoice.getCompany().getName()));

        System.out.println("\nAll invoices over 1500TL:");
        InvoiceManager.listInvoicesOverAmount(1500).forEach(invoice ->
                System.out.println("Invoice Number: " + invoice.getInvoiceNumber() + ", "
                        + "Amount: " + invoice.getTotalAmount() + ", "
                        + "Invoice Date: " + invoice.getDate() + ", "
                        + "Invoice Owner: " + invoice.getCustomer().getName() + ", "
                        + "Company: " + invoice.getCompany().getName()));

        System.out.println("\nAverage of invoices over 1500TL:");
        System.out.println(InvoiceManager.averageOfInvoicesOverAmount(1500));

        System.out.println("\nCustomers with invoices under 500TL:");
        InvoiceManager.nameOfCustomersWithInvoicesUnderAmount(500).forEach(System.out::println);

        System.out.println("\nSectors of companies with average invoice amount below 750 TL in June:");
        InvoiceManager.sectorOfCompaniesWithAverageInvoiceUnderAmountInMonth(750, Month.JUNE).forEach(System.out::println);

    }
}