package com.group12.bookinghomestay.admin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String name;
    private String country;
    private String phone;

    public Customer(String username, String email, String name, String country, String phone) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.country = country;
        this.phone = phone;
    }

    public Customer() {

    }
}
