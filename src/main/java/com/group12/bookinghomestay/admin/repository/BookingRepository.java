package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
