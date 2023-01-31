package com.group12.bookinghomestay.client.dto.request;

import com.group12.bookinghomestay.admin.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelRequest {
    private Hotel hotel;
}
