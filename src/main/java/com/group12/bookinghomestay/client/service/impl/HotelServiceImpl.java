package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.client.dto.HotelResponse;
import com.group12.bookinghomestay.client.repository.HotelClientRepository;
import com.group12.bookinghomestay.client.service.HotelClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelClientService {
    @Autowired
    private HotelClientRepository hotelClientRepository;

    @Override
    public List<HotelResponse> findGoodHotelList() {
        return hotelClientRepository.getHotelHasGoodRating();
    }

    @Override
    public List<Hotel> findAll() {
        return this.hotelClientRepository.findAll();
    }
}
