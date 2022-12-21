package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.client.model.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerClientRepository extends JpaRepository<Owner,Integer> {
}
