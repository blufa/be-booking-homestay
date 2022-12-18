package com.group12.bookinghomestay.admin.service.mapper;

import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.admin.model.Place;
import com.group12.bookinghomestay.admin.service.dto.OwnerDto;
import com.group12.bookinghomestay.admin.service.dto.PlaceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PlaceMapper {
    PlaceDto toDto(Place member);
    List<PlaceDto> toDtos(List<Place> memberList);
    Place toEntity(PlaceDto memberDTO);
}
