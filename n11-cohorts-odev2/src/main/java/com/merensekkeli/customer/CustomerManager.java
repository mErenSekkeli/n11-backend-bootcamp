package com.merensekkeli.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers);
    }

    public List<Customer> listCustomersWithLetter(char letter) {
        return customers.stream().filter(customer -> customer.getName().charAt(0) == letter).toList();
    }
}
