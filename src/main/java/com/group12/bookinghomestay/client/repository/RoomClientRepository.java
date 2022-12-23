package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomClientRepository extends JpaRepository<Room,Long> {
    @Query("SELECT r FROM Room r WHERE r.status = ?1")
    public List<Room> getRoomByState(int status);

    @Query("SELECT r FROM Room r WHERE r.id = ?1")
    public Room getRoomById(long id);
}
