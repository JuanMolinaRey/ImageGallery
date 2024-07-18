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
    private ImageGalleryService imageGalleryService;

    @GetMapping
    public ArrayList<ImageGallery> getAllImageGallery() {
        return imageGalleryService.getAllImageGallery();
    }

    @PostMapping(path = "/images")
    public ImageGallery createImageGallery(@RequestBody ImageGallery image) {
        return imageGalleryService.createImageGallery(image);
    }

    @PutMapping(path = "/images/{id}")
    public void updateImageGallery(@RequestBody ImageGallery imageGallery, @PathVariable int id) {
        imageGalleryService.updateImageGallery(imageGallery, id);
    }

    @DeleteMapping(path = "/images/{id}")
    public void deleteImageGallery(@PathVariable int id) {
        imageGalleryService.deleteImageGallery(id);
    }
}