package com.group12.bookinghomestay.client.service;

import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.model.User;

import java.util.List;

public interface UserClientService {
    boolean register(Customer customer) throws Exception;

    boolean activeAccount(String email, String token) throws Exception;

    List<User> findAll();

//    User login(String username, String password);
}
