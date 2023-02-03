package com.group12.bookinghomestay.client.controller.AuthController;


import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.client.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/register")
@CrossOrigin("*")
public class RegisterController {
    @Autowired
    UserClientService userService;

    @PostMapping("")
    @CrossOrigin("*")
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        try {
            userService.register(customer);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/active/{email}/{token}")
    @CrossOrigin("*")
    public ResponseEntity activeUser(@PathVariable("email") String email, @PathVariable("token") String token) {
        try {
            userService.activeAccount(email, token);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
