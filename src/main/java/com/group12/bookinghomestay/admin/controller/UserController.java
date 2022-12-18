package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        return userService.findById(id).get();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = PATH + "/{id}", consumes = {"application/json"})
    public User replaceUser(@RequestBody User newUser, @PathVariable("id") Long id) {
        return userService.findById(id).map(user -> {
            user.setRole(newUser.getRole());
            user.setActive(newUser.getActive());
            return userService.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return userService.save(newUser);
        });
    }
}
