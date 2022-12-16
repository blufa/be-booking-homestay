package com.group12.bookinghomestay.client.controller;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.client.dto.HotelResponse;
import com.group12.bookinghomestay.client.repository.HotelClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelClientController {
    private final String PATH = "/hotel";
    @Autowired
    HotelClientRepository repository;

    @GetMapping(PATH + "/findAllHotel")
    @CrossOrigin("*")
    public List<Hotel> findAllHotel() {
        return repository.findAll();
    }

    @GetMapping(PATH + "/findHotelGood")
    @CrossOrigin("*")
    public List<HotelResponse> findHotelGood() {
        return repository.getHotelHasGoodRating();
    }

    @GetMapping(PATH + "/{id}")
    @CrossOrigin("*")
    public Hotel getHotelById(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }
}
