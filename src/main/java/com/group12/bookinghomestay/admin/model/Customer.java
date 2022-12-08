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
    private String name;
    private String country;
    private String phone;
}
