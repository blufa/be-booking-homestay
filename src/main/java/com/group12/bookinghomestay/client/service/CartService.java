package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.client.dto.CartRequest;
import com.group12.bookinghomestay.client.dto.CartResponse;

import java.util.TreeMap;

public interface CartService {
    boolean addToCart(CartRequest item) throws Exception;

    TreeMap<Integer, CartResponse> getCartItems();

    boolean removeItemFromCart(Integer id);
}
