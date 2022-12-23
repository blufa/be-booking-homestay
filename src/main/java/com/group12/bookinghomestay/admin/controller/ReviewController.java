package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Review;
import com.group12.bookinghomestay.admin.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService service;
    private static final String PATH = "/review";

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}/hotel")
    public List<Review> getReviewListByHotelId(@PathVariable(name = "id") Long id) {
        return service.findByHotelId(id);
    }

    @CrossOrigin("*")
    @PostMapping(PATH + "/addReview")
    public Review addReview(@RequestBody Review review) {
        return service.save(review);
    }
}
