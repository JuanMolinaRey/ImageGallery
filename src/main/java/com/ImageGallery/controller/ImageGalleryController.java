package com.ImageGallery.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.service.ImageGalleryService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")

public class ImageGalleryController {
    @Autowired
    ImageGalleryService imagegalleryService;

    @DeleteMapping(path = "/images/{id}")
     public String deleteImageGallery(@PathVariable int id) {
          return imagegalleryService.deleteImageGallery(id);
     }

     @PutMapping (path = "/images/{id}")
     public void updateImageGallery(@RequestBody ImageGallery imageGallery, @PathVariable int id){
          imagegalleryService.updateImageGallery(imageGallery, id);

     }
     @GetMapping(path = "/images/{id}")
    public ArrayList<ImageGallery> getAllImageGallery() {
        return imagegalleryService.getAllImageGallery();
    }

    @PostMapping("/images")
public ImageGallery createImageGallery(@RequestBody ImageGallery image) {
    return ImageGalleryService.createImageGallery(image);

    }
}