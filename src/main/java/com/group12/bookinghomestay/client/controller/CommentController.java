package com.group12.bookinghomestay.client.controller;

import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.repository.RoomRepository;
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

    @Autowired
    RoomRepository rp;

    @GetMapping("/comment")
    @CrossOrigin("*")
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @GetMapping("/test")
    @CrossOrigin("*")
    public List<Room> al() {
        return rp.findAll();
    }
}
