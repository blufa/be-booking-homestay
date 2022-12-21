package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Review;
import com.group12.bookinghomestay.client.dto.HotelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("from Hotel a join Room b\n" +
            "on a.id = b.hotel.id\n" +
            "where b.discount > 0 and a.status=1 order by b.discount desc")
    List<Hotel> getHotelListDiscount();
}
