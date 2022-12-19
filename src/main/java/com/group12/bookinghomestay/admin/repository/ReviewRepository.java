package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select * from review group by hotel_id having avg(rate) > 3", nativeQuery = true)
    List<Review> getHotelHasGoodRating();
}