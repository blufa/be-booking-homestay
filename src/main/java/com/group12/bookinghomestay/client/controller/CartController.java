package com.group12.bookinghomestay.client.controller;

import com.group12.bookinghomestay.client.dto.response.CartResponse;
import com.group12.bookinghomestay.client.model.Cart;
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

    @PostMapping("/addToCart")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity addToCart(@RequestBody Cart item) throws Exception {
        try {
            System.out.println("received item from controller" + item.toString());
            String sessionId = service.addNewCart(item);
            return ResponseEntity.status(HttpStatus.OK).body(sessionId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This item is already in cart !");
        }
    }

    @GetMapping("/cart/{sessionId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TreeMap<Integer, CartResponse> getCartItems(@PathVariable("sessionId") String sessionId) {
        return service.getCartItems(sessionId);
    }

    @DeleteMapping("/cart/delete/{id}/{hotelId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean removeItemFromCart(@PathVariable(name = "id") String sessionId, @PathVariable(name = "hotelId") Integer id) {
        return service.removeItemFromCart(sessionId, id);
    }

}
