package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.client.model.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFacilityAdminRepository extends JpaRepository<RoomFacility, Long> {
}