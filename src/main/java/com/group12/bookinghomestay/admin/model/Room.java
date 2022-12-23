package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group12.bookinghomestay.admin.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;
    //private int hotel_id;
    private int adult;
    private int children;
    //private int type_id;
    private int status;
    private double price;
    private double discount;
    @OneToOne
    @JoinColumn(name = "type_id")
    private RoomType roomType;


    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<RoomFacility> roomFacilities;

    public Room(Hotel hotel, int adult, int children, int status, double price, double discount, RoomType roomType) {
        this.hotel = hotel;
        this.adult = adult;
        this.children = children;
        this.status = status;
        this.price = price;
        this.discount = discount;
        this.roomType = roomType;
    }
}
