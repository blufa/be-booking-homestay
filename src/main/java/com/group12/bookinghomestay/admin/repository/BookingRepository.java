package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "from Booking where hotel.id = ?1 and room.id = ?2 and current_date < dateCheckout")
    List<Booking> getReservedList(Long hotelId, Long roomId);

    @Query(value = "from Booking where hotel.id = ?1 and current_date < dateCheckout")
    List<Booking> getReservedListByHotel(Long hotelId);
    @Query("from Booking where customer.id = ?1")
    List<Booking> getBookingHistory(Long customerId);
}
