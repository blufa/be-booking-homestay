package com.group12.bookinghomestay.admin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String name;
    private String phone;
}
