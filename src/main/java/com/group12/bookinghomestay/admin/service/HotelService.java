package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
    public Hotel add(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    public void remove(int id){
         hotelRepository.deleteById(Long.valueOf(id));
    }
    public Optional<Hotel> findById(Long id){
        return hotelRepository.findById(id);
    }
}
