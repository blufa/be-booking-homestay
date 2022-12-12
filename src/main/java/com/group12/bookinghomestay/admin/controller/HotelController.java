package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.service.HotelService;
import com.group12.bookinghomestay.admin.service.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class HotelController {
    private static final String PATH="/hotel";
    @Autowired
    private HotelService hotelService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Hotel> getHotelList() {
        return hotelService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/{id}")
    public Hotel getHotelById(@PathVariable(name="id") Long id) {
        return hotelService.findById(id).get();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(PATH)
    public ResponseEntity addHotel(@RequestBody Hotel hotel){
        hotelService.add(hotel);
        return ResponseEntity.ok().body(hotel);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(PATH+"/{id}")
    public ResponseEntity  deleteHotel(@PathVariable(name = "id") Integer id){
        hotelService.remove(id);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(PATH+"/{id}")
    public Hotel replaceHotel(@RequestBody Hotel newHotel,@PathVariable Long id){
        return hotelService.findById(id).map(hotel ->{
            hotel.setName(newHotel.getName());
            hotel.setOwner(newHotel.getOwner());
            hotel.setPlace(newHotel.getPlace());
            hotel.setInfo(newHotel.getInfo());
            hotel.setPolicy(newHotel.getPolicy());
            return hotelService.add(hotel);
        }).orElseGet(()->{
            newHotel.setId(id);
            return hotelService.add(newHotel);
        });
    }
}
