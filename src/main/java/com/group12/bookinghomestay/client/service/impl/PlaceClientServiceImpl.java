package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Place;
import com.group12.bookinghomestay.client.repository.PlaceClientRepository;
import com.group12.bookinghomestay.client.service.PlaceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceClientServiceImpl implements PlaceClientService {
    @Autowired
    private PlaceClientRepository placeRepository;

    @Override
    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }
}
