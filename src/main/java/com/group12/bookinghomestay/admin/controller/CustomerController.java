package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.admin.service.CustomerService;
import com.group12.bookinghomestay.admin.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private static final String PATH="/customers";

    @Autowired
    CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/{id}")
    public Customer getById(@PathVariable long id) {
        return customerService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(PATH)
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        customerService.add(customer);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(PATH+"/{id}")
    public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable long id) {
        return customerService.findById(id).map(cusomter -> {
            cusomter.setName(newCustomer.getName());
            cusomter.setUser(newCustomer.getUser());
            cusomter.setEmail(newCustomer.getEmail());
            cusomter.setPhone(newCustomer.getPhone());
            cusomter.setCountry(newCustomer.getCountry());
            return cusomter;
        }).orElseGet(() -> {
            newCustomer.setId(id);
            return newCustomer;
        });
    }
}
