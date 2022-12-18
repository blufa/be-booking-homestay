package com.group12.bookinghomestay.admin.controller;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.model.Image;
import com.group12.bookinghomestay.admin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(PATH + "/{id}")
    public Image getImageById(@PathVariable(name = "id") Long id) {
        return imageService.findById(id).get();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = PATH + "/{id}", consumes = {"application/json"})
    public Image replaceImage(@RequestBody Image newImage, @PathVariable("id") Long id) {
        return imageService.findById(id).map(image -> {
            image.setImage(newImage.getImage());
            return imageService.save(image);
        }).orElseGet(() -> {
            newImage.setId(id);
            return imageService.save(newImage);
        });
    }
}
