package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Review;
import com.group12.bookinghomestay.admin.repository.HotelRepository;
import com.group12.bookinghomestay.admin.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public void remove(int id) {
        hotelRepository.deleteById(Long.valueOf(id));
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> findGoodHotelList() {
        List<Hotel> re = new ArrayList<>();
        List<Review> goodReviews = reviewRepository.getHotelHasGoodRating();
        for (Review r : goodReviews) {
            re.add(r.getHotel());
        }
        return re;
    }
    public List<String[]> getTotalMoneyEachDateByHotelId(Integer id){
        return hotelRepository.getTotalMoneyEachDateByHotelId(id);
    }
    public List<String[]> getTotalMoneyEachMonthAdmin(){
        return hotelRepository.getTotalMoneyEachMonthAdmin();
    }
    public List<String[]> getTotalMoneyEachDayAdmin(){
        return hotelRepository.getTotalMoneyEachDayAdmin();
    }

    public List<Hotel> getHotelListDiscount() {
        return hotelRepository.getHotelListDiscount();
    }

    public List<Hotel> searchHotelByDateAndPeople(String dateCheckout, String dateCheckin, int adult, int children, String location) {
        return hotelRepository.searchHotelByDateAndPeople(dateCheckout, dateCheckin, adult, children, location);
    }

    public List<Hotel> getGoodHotelListByLocation(String location) {
        return hotelRepository.getGoodHotelListByLocation(location);
    }
}
