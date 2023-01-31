package com.group12.bookinghomestay.client.dto.response;

import com.group12.bookinghomestay.admin.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartResponse implements Serializable {
    private Hotel hotel;
    private String from;
    private String to;
    private int adult;
    private int children;
}
