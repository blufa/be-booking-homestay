package com.group12.bookinghomestay.admin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int ownerId;
    private int placeId;
    private String info;
    private String policy;
}
