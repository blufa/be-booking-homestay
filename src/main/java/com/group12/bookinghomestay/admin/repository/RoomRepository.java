package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "select * from Room r where r.hotel_id = ?1", nativeQuery = true)
    List<Room> listRoomByHotelId(int hotelId);

    @Query("from Room a join Booking b\n" +
            "on a.hotel.id = b.hotel.id and a.id=b.room.id\n" +
            "where a.hotel.id = ?1 and current_date < b.dateCheckout and a.hotel.status=1")
    List<Room> getAvailableRooms(Long id);
}
