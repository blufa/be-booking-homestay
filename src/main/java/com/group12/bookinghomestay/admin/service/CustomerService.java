package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }
}
