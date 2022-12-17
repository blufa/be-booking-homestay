package com.group12.bookinghomestay.admin.model;

import com.group12.bookinghomestay.client.model.Facility;
import com.group12.bookinghomestay.client.model.RoomFacility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hotel_id")
    private long hotelId;
    private int adult;
    private int children;
    private int typeId;
    private int status;
    private double price;
    private double discount;

    @OneToMany
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private List<RoomFacility> facilities;


}
