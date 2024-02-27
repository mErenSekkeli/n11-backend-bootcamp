package com.merensekkeli.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static final List<Customer> customers = new ArrayList<>();

    public void addCustomer(List<Customer> customers) {
        CustomerManager.customers.addAll(customers);
    }

    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers);
    }

    public List<Customer> listCustomersWithLetterContains(char letter) {
        //not sensitive to case
        return customers.stream().filter(customer -> customer.getName().toLowerCase().contains(String.valueOf(letter).toLowerCase())).toList();
    }
}
