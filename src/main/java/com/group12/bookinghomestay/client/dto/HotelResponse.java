package com.group12.bookinghomestay.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelResponse {
    private long id;
    private String name;
    private double price;
    private double discount;
    private String province;
    private double rating;
    private String image;
}
