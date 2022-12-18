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
    //        @Query(value = "select distinct new com.group12.bookinghomestay.client.dto.HotelResponse(a.id,a.name,b.price,b.discount,c.province,avg(d.rate),e.image) from " +
//            "Hotel a join Room b\n" +
//            "on a.id = b.hotel_id\n" +
//            "join Place c on a.place_id = c.id\n" +
//            "join Review d on a.id = d.hotel_id\n" +
//            "join Image e on a.id = e.hotel_id \n" +
//            "where b.status = 0\n" +
//            "group by a.id\n" +
//            "having avg(d.rate) > 3", nativeQuery = true)

}
