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
    ImageGalleryService imagegalleryService;


     @GetMapping(path = "/images/{id}")
    public ArrayList<ImageGallery> getAllImageGallery() {
        return imagegalleryService.getAllImageGallery();
    }

    @PostMapping("/createImageGallery")
    public ImageGallery createImageGallery(@RequestBody ImageGallery image, @RequestParam int id,
                                           @RequestParam String title, @RequestParam String description,
                                           @RequestParam String url) {
        image.setId(id);
        return ImageGalleryService.createImageGallery(image, id, title, description, url);
    }
}