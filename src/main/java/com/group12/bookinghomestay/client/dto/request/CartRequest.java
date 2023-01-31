package com.group12.bookinghomestay.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartRequest implements Serializable {
    private int hotelId;
    private String from;
    private String to;
    private int adult;
    private int children;
}
