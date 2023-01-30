package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Booking;
import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.repository.BookingRepository;
import com.group12.bookinghomestay.admin.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private static final String PATH = "/booking";
    @Autowired
    BookingService bookingService;

    @CrossOrigin(origins = "*")
    @GetMapping(PATH)
    public List<Booking> getBookingList() {
        return bookingService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(PATH + "/{id}")
    public Booking getById(@PathVariable long id) {
        return bookingService.findById(id).get();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(PATH)
    public ResponseEntity addBooking(@RequestBody Booking booking) {
        bookingService.add(booking);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*")
    @PutMapping(PATH + "/{id}")
    public Booking replaceOwner(@RequestBody Booking newBooking, @PathVariable long id) {
        return bookingService.findById(id).map(booking -> {
            booking.setCustomer(newBooking.getCustomer());
            booking.setRoom(newBooking.getRoom());
            booking.setHotel(newBooking.getHotel());
            booking.setDateCheckin(newBooking.getDateCheckin());
            booking.setDateCheckout(newBooking.getDateCheckout());
            booking.setVoucherId(newBooking.getVoucherId());
            return booking;
        }).orElseGet(() -> {
            newBooking.setId(id);
            return newBooking;
        });
    }

    @CrossOrigin(origins = "*")
    @GetMapping(PATH + "/findReservedList/{hotelId}/{roomId}")
    public List<Booking> findReservedList(@PathVariable("hotelId") Long hotelId, @PathVariable("roomId") Long roomId) {
        return bookingService.getReservedList(hotelId, roomId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(PATH + "/findReservedByHotel/{hotelId}")
    public List<Booking> findReservedListByHotel(@PathVariable("hotelId") Long hotelId) {
        return bookingService.getReservedListByHotel(hotelId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(PATH + "/bookingByClient")
    public Booking bookingByClient(@RequestBody Booking booking) {
        return bookingService.saveBookingByClient(booking);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(PATH + "/getBookingHistory/{id}")
    public List<Booking> getBookingHistory(@PathVariable("id") Long id) {
        return bookingService.getBookingHistory(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(PATH + "/getBookingHistoryByUsername/{username}")
    public List<Booking> getBookingHistoryByUsername(@PathVariable("username") String username) {
        return bookingService.getBookingHistoryByUsername(username);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(PATH + "/getBookingHistoryByEmail/{email}")
    public List<Booking> getBookingHistoryByEmail(@PathVariable("email") String email) {
        return bookingService.getBookingHistoryByEmail(email);
    }


}
