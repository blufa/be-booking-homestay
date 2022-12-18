package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Comment;
import com.group12.bookinghomestay.admin.model.Report;
import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.service.CommentService;
import com.group12.bookinghomestay.admin.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    private static final String PATH="/comments";
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Comment> getCommentList() {
        return commentService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/{id}/hotel")
    public List<Comment> getCommentListByHoteId(@PathVariable(name = "id") Integer id) {
        return commentService.findByHotelId(id);
    }
}
