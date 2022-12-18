package com.group12.bookinghomestay.client.service.impl;
import com.group12.bookinghomestay.client.model.UserClient;
import com.group12.bookinghomestay.client.repository.UserRepositoryClient;
import com.group12.bookinghomestay.client.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
