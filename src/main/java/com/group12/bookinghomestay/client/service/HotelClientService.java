package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.admin.model.Hotel;

public interface HotelClientService {
    public Hotel saveHotel(Hotel hotel);
    public Hotel getHotelByName(String name);
}
