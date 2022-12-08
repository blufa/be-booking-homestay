package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Booking;
import com.group12.bookinghomestay.admin.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(long id) {
        return bookingRepository.findById(id);
    }

    public Booking add(Booking booking) {
        return bookingRepository.save(booking);
    }

}
