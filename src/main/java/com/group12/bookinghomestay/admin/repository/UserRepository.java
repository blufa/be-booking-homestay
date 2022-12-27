package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
