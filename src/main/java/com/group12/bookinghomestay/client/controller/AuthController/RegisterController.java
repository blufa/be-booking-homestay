package com.group12.bookinghomestay.client.controller.AuthController;

import com.group12.bookinghomestay.client.model.UserClient;
import com.group12.bookinghomestay.client.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class RegisterController {

    @Autowired
    private UserClientService userService;

    @PostMapping("/add")
    public String add(@RequestBody UserClient user){
        userService.saveUser(user);
        return "new user is added";
    }

    @ModelAttribute("user")
    public UserClient userRegistration() {
        return new UserClient();
    }

    @GetMapping("/getAll")
    public List<UserClient> list(){
        return userService.getAllUsers();
    }
}
