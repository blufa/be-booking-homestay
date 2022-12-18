package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.admin.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;
    private static final String PATH="/owner";
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Owner> getOwnerList() {
        return ownerService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/{id}")
    public Owner getById(@PathVariable long id) {
        return ownerService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(PATH)
    public ResponseEntity addOwner(@RequestBody Owner owner) {
        ownerService.save(owner);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(PATH+"/{id}")
    public Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable long id) {
        return ownerService.findById(id).map(owner -> {
            owner.setName(newOwner.getName());
            owner.setUsername(newOwner.getUsername());
            owner.setPhone(newOwner.getPhone());
            return ownerService.save(owner);
        }).orElseGet(() -> {
            newOwner.setId(id);
            return ownerService.save(newOwner);
        });
    }
}
