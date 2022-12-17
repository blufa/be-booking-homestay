package com.group12.bookinghomestay.client.model;

import javax.persistence.*;

@Entity
@Table(name = "hotel_facility")
public class HotelFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "facility_id")
    private Integer facilityId;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "active")
    private Integer active;

    public Integer getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public Integer getHotelId() {
        return this.hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getActive() {
        return this.active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
