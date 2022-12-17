package com.group12.bookinghomestay.client.controller;

import com.group12.bookinghomestay.client.model.Comment;
import com.group12.bookinghomestay.client.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentRepository repository;

    @GetMapping("/comment")
    @CrossOrigin("*")
    public List<Comment> findAll() {
        return repository.findAll();
    }
}
