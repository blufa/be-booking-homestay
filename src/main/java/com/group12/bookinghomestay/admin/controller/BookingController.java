package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Booking;
import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private static final String PATH="/booking";
    @Autowired
    BookingService bookingService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Booking> getBookingList() {
        return bookingService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/{id}")
    public Booking getById(@PathVariable long id) {
        return bookingService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(PATH)
    public ResponseEntity addBooking(@RequestBody Booking booking) {
        bookingService.add(booking);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(PATH+"/{id}")
    public Booking replaceOwner(@RequestBody Booking newBooking, @PathVariable long id) {
        return bookingService.findById(id).map(booking -> {
            booking.setCustomerId(newBooking.getCustomerId());
            booking.setRoomId(newBooking.getRoomId());
            booking.setHotelId(newBooking.getHotelId());
            booking.setDateCheckin(newBooking.getDateCheckin());
            booking.setDateCheckout(newBooking.getDateCheckout());
            booking.setVoucherId(newBooking.getVoucherId());
            return booking;
        }).orElseGet(() -> {
            newBooking.setId(id);
            return newBooking;
        });
    }
}
