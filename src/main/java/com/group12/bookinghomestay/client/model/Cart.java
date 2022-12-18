package com.group12.bookinghomestay.client.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;
    private int hotelId;
    private String fromDate;
    private String toDate;
    private int adult;
    private int children;
}
