package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
    public Room add(Room room){
        return roomRepository.save(room);
    }
    public void remove(int id){
        roomRepository.deleteById(Long.valueOf(id));
    }
    public Optional<Room> findById(Long id){
        return roomRepository.findById(id);
    }
}
