package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
