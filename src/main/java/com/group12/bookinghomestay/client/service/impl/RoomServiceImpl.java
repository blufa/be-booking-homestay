package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.client.repository.RoomClientRepository;
import com.group12.bookinghomestay.client.service.RoomClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomClientService {
    @Autowired
    RoomClientRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getRoomByState(int status) {
        return roomRepository.getRoomByState(status);
    }

    @Override
    public Room getRoomById(long id) {
        return roomRepository.getRoomById(id);
    }
}
