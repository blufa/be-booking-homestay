package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Comment;
import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
@Autowired
    private CommentRepository commentRepository;
    public List<Comment> findAll(){
        return  commentRepository.findAll();
    }
    public List<Comment> findByHotelId(int id) {
        return commentRepository.listCommentByHotelId(id);
    }
}
