package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Facility;
import com.group12.bookinghomestay.admin.model.HotelFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelFacilityRepository extends JpaRepository<HotelFacility,Long> {
}
