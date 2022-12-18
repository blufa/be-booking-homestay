package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query(value = "select * from Room r where r.hotel_id = ?1", nativeQuery = true)
    List<Room> listRoomByHotelId(int hotelId);
}
