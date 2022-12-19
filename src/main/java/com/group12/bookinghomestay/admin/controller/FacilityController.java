package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Facility;
import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.RoomFacility;
import com.group12.bookinghomestay.admin.service.FacilityService;
import com.group12.bookinghomestay.admin.service.RoomFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}")
    public Facility getFacilityById(@PathVariable(name = "id") Long id) {
        return facilityService.findById(id).get();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = PATH + "/{id}", consumes = {"application/json"})
    public Facility replaceFacility(@RequestBody Facility newFacility, @PathVariable("id") Long id) {
        return facilityService.findById(id).map(facility -> {
            facility.setName(newFacility.getName());

            facility.setType(newFacility.getType());
            facility.setDescription(newFacility.getDescription());
            return facilityService.save(facility);
        }).orElseGet(() -> {
            newFacility.setId(id);
            return facilityService.save(newFacility);
        });
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(PATH + "/{facilityId}/room/{roomId}")
    public void deleteRoomFacility(@PathVariable(name = "facilityId") Integer facilityId,@PathVariable(name = "roomId") Integer roomId) {
        roomFacilityService.removeRoomFacility(facilityId,roomId);

    }
}
