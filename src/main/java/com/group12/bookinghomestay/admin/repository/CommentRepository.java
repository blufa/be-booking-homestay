package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("from Comment where hotel.id = ?1")
    List<Comment> listCommentByHotelId(int hotelId);
}
