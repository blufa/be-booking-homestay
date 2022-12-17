package com.group12.bookinghomestay.client.controller;

import com.group12.bookinghomestay.client.dto.CartRequest;
import com.group12.bookinghomestay.client.dto.CartResponse;
import com.group12.bookinghomestay.client.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
public class CartController {
    @Autowired
    CartService service;

    @GetMapping("/cart")
    public TreeMap<Integer, CartResponse> getCartItems() {
        return service.getCartItems();
    }

    @PostMapping("/addToCart")
    public ResponseEntity addToCart(@RequestBody CartRequest item) throws Exception {
        try {
            service.addToCart(item);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This item is already in cart !");
        }
    }

    @DeleteMapping("/cart/delete/{id}")
    public boolean removeItemFromCart(@PathVariable(name = "id") Integer id) {
        return service.removeItemFromCart(id);
    }
}
