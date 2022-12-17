package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
