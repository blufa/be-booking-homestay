package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Image;
import com.group12.bookinghomestay.admin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;
    private static final String PATH="/images";
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH)
    public List<Image> getImageList() {
        return imageService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH+"/{id}/hotel")
    public List<Image> getImageListByHoteId(@PathVariable(name = "id") Integer id) {
        return imageService.findByHotelId(id);
    }
}
