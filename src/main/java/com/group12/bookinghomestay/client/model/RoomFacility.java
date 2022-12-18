package com.group12.bookinghomestay.client.model;

import com.group12.bookinghomestay.admin.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "room_facility")
public class RoomFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "active")
    private Integer active;

    @OneToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;
}
