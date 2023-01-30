package com.group12.bookinghomestay.client.repository;

import com.group12.bookinghomestay.admin.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerClientRepository extends JpaRepository<Owner,Long> {
    @Query("SELECT o FROM Owner o WHERE o.username = ?1")
    public Owner getOwnerByUserName(String username);
}
