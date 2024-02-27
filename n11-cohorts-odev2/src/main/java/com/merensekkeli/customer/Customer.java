package com.merensekkeli.customer;

import java.time.LocalDate;

public class Customer {

    private final Long id;
    private String name;
    private String email;
    private LocalDate registrationDate;

    public Customer(Long id, String name, String email, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

}
