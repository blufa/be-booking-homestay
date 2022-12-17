package com.group12.bookinghomestay.admin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private Date dateCheckin;
    private Date dateCheckout;
    private long voucherId;
}
