package com.ImageGallery.controller;

import com.ImageGallery.model.ImageGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ImageGallery.service.ImageGalleryService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")

public class ImageGalleryController {
    @Autowired
    ImageGalleryService imagegalleryService;

    @DeleteMapping(path = "/images/{id}")
    public void deleteImageGallery(@PathVariable int id) {
        imagegalleryService.deleteImageGallery(id);
    }

    @PutMapping (path = "/images/{id}")
    public void updateImageGallery(@RequestBody ImageGallery imageGallery, @PathVariable int id){
        imagegalleryService.updateImageGallery(imageGallery, id);

    }
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