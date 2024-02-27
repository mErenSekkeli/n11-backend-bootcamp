package com.merensekkeli.invoice;

import com.merensekkeli.company.Company;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceManager {
    private static List<Invoice> invoices = new ArrayList<>();

    private static Map<String, Company> companies = new HashMap<>();

    public static void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public static void addCompany(Company company) {
        companies.put(company.getName(), company);
    }

    public static void addInvoiceToCompany(String companyName, Invoice invoice) {
        if (companies.containsKey(companyName)) {
            companies.get(companyName).addInvoice(invoice);
        }
    }

    public static double getTotalAmountForCustomersRegisteredInAMonth(Month month) {
        return invoices.stream()
                .filter(i -> i.getCustomer().getRegistrationDate().getMonth().equals(month))
                .mapToDouble(Invoice::getTotalAmount)
                .sum();
    }

    public static List<Invoice> listAllInvoices() {
        return new ArrayList<>(invoices);
    }

    public static List<Invoice> listInvoicesOverAmount(double amount) {
        return invoices.stream().filter(i -> i.getTotalAmount() > amount).toList();
    }

    public static double averageOfInvoicesOverAmount(double amount) {
        return invoices.stream()
                .filter(i -> i.getTotalAmount() > amount)
                .mapToDouble(Invoice::getTotalAmount)
                .average()
                .orElse(0);
    }

    public static List<String> nameOfCustomersWithInvoicesUnderAmount(double amount) {
        return invoices.stream()
                .filter(i -> i.getTotalAmount() < amount)
                .map(i -> i.getCustomer().getName())
                .toList();
    }

    public static List<String> sectorOfCompaniesWithAverageInvoiceUnderAmountInMonth(double amount, Month month) {
        return companies.values().stream()
                .filter(company -> {
                    double average = company.getInvoices().stream()
                            .filter(invoice -> invoice.getDate().getMonth().equals(month))
                            .mapToDouble(Invoice::getTotalAmount)
                            .average()
                            .orElse(0);
                    return average < amount && average > 0;
                })
                .map(Company::getSector)
                .collect(Collectors.toList());
    }

    /*
        addCustomer(Customer customer)
        List<Customer> listAllCustomers()
        List<Customer> listCustomersWithLetter(char letter)
        getTotalAmountForCustomersRegisteredInAMonth(Month month)
        List<Invoice> listAllInvoices()
        List<Invoice> listInvoicesOverAmount(double amount)
        double averageOfInvoicesOverAmount(double amount)
        List<String> nameOfCustomersWithInvoicesUnderAmount(double amount)
        List<String> sectorOfCompaniesWithAverageInvoiceUnderAmountInMonth(double amount, Month month)
     */

}
