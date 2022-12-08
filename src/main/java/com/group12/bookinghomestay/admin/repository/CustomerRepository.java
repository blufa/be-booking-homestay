package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
