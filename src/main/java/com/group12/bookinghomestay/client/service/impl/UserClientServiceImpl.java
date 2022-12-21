package com.group12.bookinghomestay.client.service.impl;
import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.client.model.UserClient;
import com.group12.bookinghomestay.client.repository.UserRepositoryClient;
import com.group12.bookinghomestay.client.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserClientServiceImpl implements UserClientService {

    @Autowired
    private UserRepositoryClient userRepository;

    @Override
    public UserClient saveUser(UserClient user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserClient> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserClient> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UserClient getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserClient> getListUserByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    @Override
    public UserClient getUserByUserName(String username) {
        return userRepository.getUserByUserName(username);
    }

    @Override
    public List<UserClient> getAllUserByUserName(String username) {
        return userRepository.getAllByUserName(username);
    }


    @Override
    public UserClient getUserByToken(String token) {
        return userRepository.getUserByToken(token);
    }


}
