package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.model.User;
import com.group12.bookinghomestay.admin.model.enums.UserStatus;
import com.group12.bookinghomestay.client.repository.UserRepositoryClient;
import com.group12.bookinghomestay.client.service.CustomerClientService;
import com.group12.bookinghomestay.client.service.EmailService.EmailSenderService;
import com.group12.bookinghomestay.client.service.UserClientService;
import com.group12.bookinghomestay.client.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserClientService {
    @Autowired
    private UserRepositoryClient userRepository;
    @Autowired
    private EmailSenderService emailService;
    @Autowired
    CustomerClientService customerService;

    @Override
    public boolean register(Customer customer) throws Exception {
        User user = customer.getUser();
        User existedUser = userRepository.findExistedUser(user.getEmail(), user.getUsername());
        if (existedUser != null) {
            throw new Exception("User is already existed !");
        }
        user.setPassword(MD5.getHashedString(user.getPassword()));
        String token = KeyGenerators.string().generateKey();
        user.setToken(token);
        userRepository.save(user);
        emailService.sendActiveEmail(user.getEmail(), token);
        customerService.saveCustomer(customer);
        return true;
    }

    @Override
    public boolean activeAccount(String email, String token) throws Exception {
        User user = userRepository.findUserByEmail(email, token);
        if (user == null) throw new Exception("Error while activating account");
        user.setToken(null);
        user.setActive(UserStatus.ACTIVATED);
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
