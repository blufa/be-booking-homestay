package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group12.bookinghomestay.admin.model.enums.RoomStatus;
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
    private int adult;
    private int children;
    @Enumerated(EnumType.ORDINAL)
    private RoomStatus status;
    private double price;
    private double discount;
    @OneToOne
    @JoinColumn(name = "type_id")
    private RoomType roomType;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<RoomFacility> roomFacilities;
}
