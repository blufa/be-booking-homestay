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

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getCustomerList")
    public List<Customer> getOwnerList() {
        return customerService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getCustomer/{id}")
    public Customer getById(@PathVariable long id) {
        return customerService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("addCustomer")
    public ResponseEntity addOwner(@RequestBody Customer customer) {
        customerService.add(customer);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("replaceCustomer/{id}")
    public Customer replaceOwner(@RequestBody Customer newCustomer, @PathVariable long id) {
        return customerService.findById(id).map(cusomter -> {
            cusomter.setName(newCustomer.getName());
            cusomter.setUsername(newCustomer.getUsername());
            cusomter.setPhone(newCustomer.getPhone());
            cusomter.setCountry(newCustomer.getCountry());
            return cusomter;
        }).orElseGet(() -> {
            newCustomer.setId(id);
            return newCustomer;
        });
    }
}
