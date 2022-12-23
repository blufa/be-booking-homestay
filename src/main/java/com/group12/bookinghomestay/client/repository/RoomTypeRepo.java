package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.admin.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepo extends JpaRepository<RoomType,Long> {

}
