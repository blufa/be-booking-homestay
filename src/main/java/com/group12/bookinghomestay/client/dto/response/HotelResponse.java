package com.group12.bookinghomestay.client.dto.response;

import com.group12.bookinghomestay.admin.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelResponse {
    private Hotel hotel;
    private double rate;
}
