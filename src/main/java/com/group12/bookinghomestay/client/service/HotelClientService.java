package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.client.dto.HotelResponse;

import java.util.List;
import java.util.Optional;

public interface HotelClientService {
    List<HotelResponse> findGoodHotelList();

    List<Hotel> findAll();

    Optional<Hotel> findById(Long id);
}
