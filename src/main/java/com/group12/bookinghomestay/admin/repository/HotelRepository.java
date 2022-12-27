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

    @Query(value = "select distinct a.*\n" +
            "from Hotel a join Room b\n" +
            "on a.id = b.hotel_id\n" +
            "join Booking c\n" +
            "on b.id=c.room_id\n" +
            "join place d on a.place_id = d.id\n" +
            "where DATE(:dateCheckout) > c.date_checkout \n" +
            "and DATE(:dateCheckin) > c.date_checkin and a.status = 1\n" +
            "and b.adult > :adult and b.children > :children\n" +
            "and POSITION(:location in concat(address,' ' ,district,' ',province,' ',country))", nativeQuery = true)
    List<Hotel> searchHotelByDateAndPeople(@Param("dateCheckout") String dateCheckout, @Param("dateCheckin") String dateCheckin,
                                           @Param("adult") int adult, @Param("children") int children,
                                           @Param("location") String location);

    @Query(value = "select distinct a.*\n" +
            "from Hotel a join Room b\n" +
            "on a.id = b.hotel_id\n" +
            "join Booking c\n" +
            "on b.id=c.room_id\n" +
            "join place d on a.place_id = d.id\n" +
            "join review e on e.hotel_id = a.id\n" +
            "where NOW() > c.date_checkout \n" +
            "and NOW() > c.date_checkin and a.status = 1\n" +
            "and POSITION(:location in concat(address,' ' ,district,' ',province,' ',country))\n" +
            "group by a.id\n" +
            "having avg(rate) > 3", nativeQuery = true)
    List<Hotel> getGoodHotelListByLocation(@Param("location") String location);
    @Query(value = "select b.full_date,sum(c.price) from date_dim b " +
            "inner join  booking a on (b.full_date<= a.date_checkout and b.full_date>= a.date_checkin) " +
            "join room c on a.room_id=c.id where a.hotel_id=:hotelId group by b.full_date", nativeQuery = true)
    List<String[]> getTotalMoneyEachDateByHotelId(@Param("hotelId") Integer hotelId);

    @Query(value = "select b.calendar_month,sum(c.price)*0.1 from date_dim b inner join  booking a on (b.full_date<= a.date_checkout and b.full_date>= a.date_checkin) join room c on a.room_id=c.id group by b.calendar_month", nativeQuery = true)
    List<String[]> getTotalMoneyEachMonthAdmin();
    @Query(value = "select b.full_date,sum(c.price)*0.1 from date_dim b inner join  booking a on (b.full_date<= a.date_checkout and b.full_date>= a.date_checkin) join room c on a.room_id=c.id group by b.full_date ORDER by b.date_sk DESC LIMIT 7", nativeQuery = true)
    List<String[]> getTotalMoneyEachDayAdmin();
}
