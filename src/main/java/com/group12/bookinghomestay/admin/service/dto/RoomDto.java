package com.group12.bookinghomestay.admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private int adult;
    private int children;
    private int typeId;
    private int status;
    private double price;
    private double discount;
}
