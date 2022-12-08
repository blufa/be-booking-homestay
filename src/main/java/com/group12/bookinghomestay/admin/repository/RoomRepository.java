package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
