package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.group12.bookinghomestay.admin.model.enums.BookingStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.cache.CacheType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCheckin;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCheckout;
    private String voucherId;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
