package com.group12.bookinghomestay.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel_facility")
public class HotelFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private int active;

}
