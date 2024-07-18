package com.ImageGallery.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping (path = "/images/{id}")
    public void updateImageGallery(@RequestBody ImageGallery imageGallery, @PathVariable int id, @RequestParam String title, @RequestParam String url, @RequestParam String description){
        imageGalleryService.updateImageGallery(imageGallery, id, title, description, url);
    }

    @DeleteMapping(path = "/images/{id}")
    public void deleteImageGallery(@PathVariable int id) {
        imageGalleryService.deleteImageGallery(id);
    }
}