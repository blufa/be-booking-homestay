package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Facility;
import com.group12.bookinghomestay.admin.model.RoomFacility;
import com.group12.bookinghomestay.admin.service.FacilityService;
import com.group12.bookinghomestay.admin.service.RoomFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacilityController {
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private RoomFacilityService roomFacilityService;
    private static final String PATH="/facilities";
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Facility> getFacilityList() {
        return facilityService.getAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/room")
    public List<RoomFacility> getRoomFacilityList() {
        return roomFacilityService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/room/{id}")
    public List<RoomFacility> getRoomFacilityListByRoomId(@PathVariable("id") int id) {
        return roomFacilityService.listRoomFacilityByRoomId(id);
    }

}
