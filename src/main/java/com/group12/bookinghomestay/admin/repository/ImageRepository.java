package com.group12.bookinghomestay.admin.repository;

import com.group12.bookinghomestay.admin.model.Image;
import com.group12.bookinghomestay.admin.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageRepository  extends JpaRepository<Image,Long> {
    @Query(value = "select * from Image r where r.hotel_id = ?1", nativeQuery = true)
    List<Image> listImageByHotelId(int hotelId);
}
