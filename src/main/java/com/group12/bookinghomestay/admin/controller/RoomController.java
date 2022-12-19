package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.repository.RoomRepository;
import com.group12.bookinghomestay.admin.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;
    private static final String PATH = "/rooms";

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Room> getRoomList() {
        return roomService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}/hotel")
    public List<Room> getRoomListByHoteId(@PathVariable(name = "id") Integer id) {
        return roomService.findByHotelId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(PATH)
    public ResponseEntity addRoom(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.ok().body(room);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity deleteRoom(@PathVariable(name = "id") Integer id) {
        roomService.remove(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(PATH + "/{id}")
    public Room replaceRoom(@RequestBody Room newRoom, @PathVariable Long id) {
        return roomService.findById(id).map(room -> {
            room.setAdult(newRoom.getAdult());
            room.setChildren(newRoom.getChildren());
            room.setStatus(newRoom.getStatus());
            room.setPrice(newRoom.getPrice());
            room.setDiscount(newRoom.getDiscount());
            return roomService.save(room);
        }).orElseGet(() -> {
            newRoom.setId(id);
            return roomService.save(newRoom);
        });
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/getAvailableRoom/{id}")
    public List<Room> findAvailableRoom(@PathVariable("id") Long hotelId) {
        return roomService.findAvailableRoom(hotelId);
    }
}
