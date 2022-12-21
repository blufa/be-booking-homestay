package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Review;
import com.group12.bookinghomestay.client.dto.HotelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query(value = "select b.full_date,sum(c.price) from date_dim b " +
            "inner join  booking a on (b.full_date<= a.date_checkout and b.full_date>= a.date_checkin) " +
            "join room c on a.room_id=c.id where a.hotel_id=:hotelId group by b.full_date", nativeQuery = true)
    List<String[]> getTotalMoneyEachDateByHotelId(@Param("hotelId") Integer hotelId);

    @Query(value = "select b.calendar_month,sum(c.price)*0.1 from date_dim b inner join  booking a on (b.full_date<= a.date_checkout and b.full_date>= a.date_checkin) join room c on a.room_id=c.id group by b.calendar_month", nativeQuery = true)
    List<String[]> getTotalMoneyEachMonthAdmin();
    @Query(value = "select b.full_date,sum(c.price)*0.1 from date_dim b inner join  booking a on (b.full_date<= a.date_checkout and b.full_date>= a.date_checkin) join room c on a.room_id=c.id group by b.full_date ORDER by b.date_sk DESC LIMIT 7", nativeQuery = true)
    List<String[]> getTotalMoneyEachDayAdmin();
}
