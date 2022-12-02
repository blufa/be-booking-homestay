package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelReposity extends JpaRepository<Hotel,Long> {
}
