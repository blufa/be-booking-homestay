package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
