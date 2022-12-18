package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room_facility")
public class RoomFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference
    private Room room;
    private int active;

}
