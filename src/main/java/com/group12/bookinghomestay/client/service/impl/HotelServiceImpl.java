package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.client.repository.HotelClientRepository;
import com.group12.bookinghomestay.client.service.HotelClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelClientService {
    @Autowired
    HotelClientRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelByName(String name) {
        return hotelRepository.getHotelByName(name);
    }
}
