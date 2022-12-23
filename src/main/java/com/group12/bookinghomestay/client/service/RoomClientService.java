package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.admin.model.Room;

import java.util.List;

public interface RoomClientService {
    public Room saveRoom(Room room);
    public List<Room> getRoomByState(int status);
    public Room getRoomById(long id);
}
