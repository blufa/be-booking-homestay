package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.client.dto.HotelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelClientRepository extends JpaRepository<Hotel, Long> {
    @Query("select distinct new com.group12.bookinghomestay.client.dto.HotelResponse(a.id,a.name,b.price,b.discount,c.province,avg(d.rate),e.image) from " +
            "Hotel a join Room b\n" +
            "on a.id = b.hotelId\n" +
            "join Place c on a.placeId = c.id\n" +
            "join Review d on a.id = d.hotelId\n" +
            "join Image e on a.id = e.hotelId \n" +
            "where b.status = 0\n" +
            "group by a.id\n" +
            "having avg(d.rate) > 3")
    List<HotelResponse> getHotelHasGoodRating();
}
