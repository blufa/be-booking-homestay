package com.group12.bookinghomestay.admin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long hotelId;
    private int adult;
    private int children;
    private int typeId;
    private int status;
    private double price;
    private double discount;
}
