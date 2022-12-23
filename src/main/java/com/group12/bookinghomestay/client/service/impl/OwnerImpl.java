package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.client.repository.OwnerClientRepository;
import com.group12.bookinghomestay.client.service.OwnerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerImpl implements OwnerClientService {
    @Autowired
    private OwnerClientRepository ownerRepository;
    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerByUserName(String username) {
        return ownerRepository.getOwnerByUserName(username);
    }

}
