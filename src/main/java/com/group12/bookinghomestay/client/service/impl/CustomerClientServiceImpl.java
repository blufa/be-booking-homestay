package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.client.repository.CustomerClientRepository;
import com.group12.bookinghomestay.client.service.CustomerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerClientServiceImpl implements CustomerClientService {

    @Autowired
    private CustomerClientRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
