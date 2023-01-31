package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.client.dto.response.CartResponse;
import com.group12.bookinghomestay.client.model.Cart;

import java.util.TreeMap;

public interface CartService {
    String addNewCart(Cart item) throws Exception;

    TreeMap<Integer, CartResponse> getCartItems(String id);

    boolean removeItemFromCart(String sessionId, int hotelId);
}
