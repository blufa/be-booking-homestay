package com.group12.bookinghomestay.admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {
    private String address;
    private String district;
    private String province;
    private String country;
}
