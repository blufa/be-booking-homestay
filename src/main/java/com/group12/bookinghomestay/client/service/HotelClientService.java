package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.client.dto.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelClientService {
    List<HotelResponse> findGoodHotelList();
    List<Hotel> findAll();
}
