package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Comment;
import com.group12.bookinghomestay.admin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    private static final String PATH = "/comments";

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Comment> getCommentList() {
        return commentService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}/hotel")
    public List<Comment> getCommentListByHoteId(@PathVariable(name = "id") Integer id) {
        return commentService.findByHotelId(id);
    }

    @CrossOrigin("*")
    @PostMapping(PATH + "/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }
}
