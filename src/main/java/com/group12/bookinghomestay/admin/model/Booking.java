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
    private long customerId;
    private long hotelId;
    private long roomId;
    private Date dateCheckin;
    private Date dateCheckout;
    private long voucherId;
}
