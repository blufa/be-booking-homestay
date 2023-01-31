package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Booking;
import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.repository.BookingRepository;
import com.group12.bookinghomestay.admin.repository.CustomerRepository;
import com.group12.bookinghomestay.client.service.EmailService.EmailSenderService;
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
    @Autowired
    private EmailSenderService emailService;

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
        Booking savedBooking = bookingRepository.save(booking);
        if (savedBooking != null) {
            String toEmail = c.getEmail();
            String subject = "Booking information";
            String body = "Hi, " + c.getName() + "\n" + "Thanks for choosing us ! This email sent to you to announce that you have booked successfully ! Please check your information below if there was mistake please contact with us :\n" +
                    "- Booking id : " + savedBooking.getId() + "\n" +
                    "- Hotel : " + savedBooking.getHotel().getName() + "\n" +
                    "- Checkin date : " + savedBooking.getDateCheckin() + "\n" +
                    "- Checkout date : " + savedBooking.getDateCheckout() + "\n" +
                    "- Price : " + savedBooking.getRoom().getPrice() + "\n" +
                    "- Status : " + savedBooking.getStatus();
            emailService.sendSimpleEmail(toEmail, body, subject);
        }
        return savedBooking;
    }

    public List<Booking> getBookingHistory(Long customerId) {
        return bookingRepository.getBookingHistory(customerId);
    }

    public List<Booking> getBookingHistoryByUsername(String username) {
        return bookingRepository.getBookingHistoryByUsername(username);
    }

    public List<Booking> getBookingHistoryByEmail(String input) {
        return bookingRepository.getBookingHistoryByEmail(input);
    }
}
