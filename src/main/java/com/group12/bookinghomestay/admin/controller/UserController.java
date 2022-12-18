package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private static final String PATH="/users";
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<User> getRoomList() {
        return userService.findAll();
    }
}
