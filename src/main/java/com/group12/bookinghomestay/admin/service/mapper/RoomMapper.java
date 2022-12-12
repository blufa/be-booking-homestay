package com.group12.bookinghomestay.admin.service.mapper;

import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.service.dto.OwnerDto;
import com.group12.bookinghomestay.admin.service.dto.RoomDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RoomMapper {
    RoomDto toDto(Room member);
    List<RoomDto> toDtos(List<Room> memberList);
    Room toEntity(RoomDto memberDTO);
}
