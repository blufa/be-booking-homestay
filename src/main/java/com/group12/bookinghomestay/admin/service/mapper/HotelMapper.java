package com.group12.bookinghomestay.admin.service.mapper;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.service.dto.HotelDto;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper(componentModel = "cdi")
public interface HotelMapper {
    HotelDto toDto(Hotel member);
    List<HotelDto> toDtos(List<Hotel> memberList);
    Hotel toEntity(HotelDto memberDTO);
}
