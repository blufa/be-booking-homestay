package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.client.model.UserClient;

import java.util.List;

public interface UserClientService {
    public UserClient saveUser(UserClient user);
    public List<UserClient> getAllUsers();
}
