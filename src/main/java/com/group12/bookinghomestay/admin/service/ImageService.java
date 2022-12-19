package com.group12.bookinghomestay.admin.service;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Image;
import com.group12.bookinghomestay.admin.model.Room;
import com.group12.bookinghomestay.admin.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    public List<Image> findAll(){
        return imageRepository.findAll();
    }
    public List<Image> findByHotelId(int id) {
        return imageRepository.listImageByHotelId(id);
    }
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }
}
