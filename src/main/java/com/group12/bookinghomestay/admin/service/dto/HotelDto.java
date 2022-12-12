package com.group12.bookinghomestay.admin.service.dto;

import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.admin.model.Place;
import com.group12.bookinghomestay.admin.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private long id;

    private String name;
    private Owner owner;
    private Place place;
    private String info;
    private String policy;
    private Collection<Room> room;

}
