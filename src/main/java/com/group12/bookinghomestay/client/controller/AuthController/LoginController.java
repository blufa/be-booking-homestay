package com.group12.bookinghomestay.client.controller.AuthController;

import com.group12.bookinghomestay.admin.service.UserService;
import com.group12.bookinghomestay.client.dto.request.UserRequest;
import com.group12.bookinghomestay.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("")
    public ResponseEntity<String> login(@RequestBody UserRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userService.findById(request.getUsername()).orElseThrow();
        return ResponseEntity.ok().body(jwtUtils.generateToken(user));
    }
}
