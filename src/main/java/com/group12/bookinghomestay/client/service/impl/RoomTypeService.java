package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.RoomType;
import com.group12.bookinghomestay.client.repository.RoomTypeRepo;
import com.group12.bookinghomestay.client.service.RoomTypeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService  implements RoomTypeClientService {
    @Autowired
    private RoomTypeRepo typeRepo;

    public RoomType saveRoomType(RoomType roomType){
        return typeRepo.save(roomType);
    }
}
