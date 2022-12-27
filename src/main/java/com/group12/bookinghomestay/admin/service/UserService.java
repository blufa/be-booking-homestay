package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(String username) {
        return userRepository.findById(username);
    }
}
