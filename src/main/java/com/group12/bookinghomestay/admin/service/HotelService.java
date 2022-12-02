package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.repository.HotelReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelReposity hotelReposity;

    public List<Hotel> findAll() {
        return hotelReposity.findAll();
    }
    public Hotel add(Hotel hotel){
        return hotelReposity.save(hotel);
    }
    public void remove(int id){
         hotelReposity.deleteById(Long.valueOf(id));
    }
}
