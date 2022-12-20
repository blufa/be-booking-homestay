package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.client.model.UserClient;

import java.util.List;
import java.util.Optional;

public interface UserClientService {
    public UserClient saveUser(UserClient user);
    public List<UserClient> getAllUsers();
    public Optional<UserClient> getUserById(int id);
    public UserClient getUserByEmail(String email);
    public List<UserClient> getListUserByEmail(String Email);
    public UserClient getUserByUserName(String username);
    public List<UserClient> getAllUserByUserName(String username);
}
