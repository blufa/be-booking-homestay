package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "from Review group by hotel.id having avg(rate) > 3")
    List<Review> getHotelHasGoodRating();

    @Query("from Review where hotel.id = ?1")
    List<Review> getReviewByHotelId(Long id);
}