package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Review;
import com.group12.bookinghomestay.admin.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public List<Review> findByHotelId(Long id) {
        return reviewRepository.getReviewByHotelId(id);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}
