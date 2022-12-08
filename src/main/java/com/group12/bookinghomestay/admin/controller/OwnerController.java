package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.admin.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getOwnerList")
    public List<Owner> getOwnerList() {
        return ownerService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getOwner/{id}")
    public Owner getById(@PathVariable long id) {
        return ownerService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("addOwner")
    public ResponseEntity addOwner(@RequestBody Owner owner) {
        ownerService.add(owner);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("replaceOwner/{id}")
    public Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable long id) {
        return ownerService.findById(id).map(owner -> {
            owner.setName(newOwner.getName());
            owner.setUsername(newOwner.getUsername());
            owner.setPhone(newOwner.getPhone());
            return owner;
        }).orElseGet(() -> {
            newOwner.setId(id);
            return newOwner;
        });
    }
}
