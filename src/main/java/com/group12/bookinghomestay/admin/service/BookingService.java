package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Booking;
import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.repository.BookingRepository;
import com.group12.bookinghomestay.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(long id) {
        return bookingRepository.findById(id);
    }

    public Booking add(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getReservedList(Long hotelId, Long roomId) {
        return bookingRepository.getReservedList(hotelId, roomId);
    }

    public List<Booking> getReservedListByHotel(Long hotelId) {
        return bookingRepository.getReservedListByHotel(hotelId);
    }

    public Booking saveBookingByClient(Booking booking) {
        Customer c = customerRepository.getCustomerExisted(booking.getCustomer().getEmail(), booking.getCustomer().getPhone());
        if (c == null) {
            c = customerRepository.save(booking.getCustomer());
        }
        booking.setCustomer(c);
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingHistory(Long customerId) {
        return bookingRepository.getBookingHistory(customerId);
    }
}
