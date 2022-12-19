package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomFacilityRepository extends JpaRepository<RoomFacility,Long> {

    @Query(value = "select * from room_facility rf where rf.room_id = ?1", nativeQuery = true)
    List<RoomFacility> listRoomFacilityByRoomId(int RoomId);

    @Modifying
    @Query(value = "delete from room_facility rf where rf.facility_id=?1 and rf.room_id = ?2", nativeQuery = true)
    void deleteRoomFacility(int facilityId,int roomId);
}
