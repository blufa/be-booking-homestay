package com.group12.bookinghomestay.admin.service.mapper;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.admin.service.dto.HotelDto;
import com.group12.bookinghomestay.admin.service.dto.OwnerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface OwnerMapper {
    OwnerDto toDto(Owner member);
    List<OwnerDto> toDtos(List<Owner> memberList);
    Owner toEntity(OwnerDto memberDTO);
}
