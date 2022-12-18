package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.client.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentAdminRepository extends JpaRepository<Comment, Integer> {
}