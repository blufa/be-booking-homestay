package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("from Hotel a join Room b\n" +
            "on a.id = b.hotel.id\n" +
            "where b.discount > 0 and a.status=1 order by b.discount desc")
    List<Hotel> getHotelListDiscount();

    //    @Query("from Hotel a join Room b\n" +
//            "on a.id = b.hotel.id\n" +
//            "join Booking c\n" +
//            "on b.id = c.room.id\n" +
//            "join Place d on a.id = d.id\n" +
//            "where DATE(?1) > c.dateCheckin \n" +
//            "and DATE(?2) > c.dateCheckout and a.status = 1\n" +
//            "and b.adult > ?3 and b.children > ?4 and d.province ")
    @Query(value = "select distinct a.*\n" +
            "from Hotel a join Room b\n" +
            "on a.id = b.hotel_id\n" +
            "join Booking c\n" +
            "on b.id=c.room_id\n" +
            "join place d on a.place_id = d.id\n" +
            "where DATE(:dateCheckout) > c.date_checkout \n" +
            "and DATE(:dateCheckin) > c.date_checkin and a.status = 1\n" +
            "and b.adult > :adult and b.children > :children\n" +
            "and POSITION(:location in concat(address,district,province,country))", nativeQuery = true)
    List<Hotel> searchHotelByDateAndPeople(@Param("dateCheckout") String dateCheckout, @Param("dateCheckin") String dateCheckin,
                                           @Param("adult") int adult, @Param("children") int children,
                                           @Param("location") String location);
}
