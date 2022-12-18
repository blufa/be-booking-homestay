package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.RoomFacility;
import com.group12.bookinghomestay.admin.repository.RoomFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomFacilityService {
    @Autowired
    private RoomFacilityRepository roomFacilityRepository;
    public List<RoomFacility> findAll(){
        return roomFacilityRepository.findAll();
    }
    public List<RoomFacility> listRoomFacilityByRoomId(int roomId){
        return roomFacilityRepository.listRoomFacilityByRoomId(roomId);
    }
    public void remove(int id) {
        roomFacilityRepository.deleteById(Long.valueOf(id));
    }
    public void removeRoomFacility(int facilityId,int roomId){
        roomFacilityRepository.deleteRoomFacility(facilityId,roomId);
    }
}
