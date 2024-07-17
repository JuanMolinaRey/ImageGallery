package com.ImageGallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ImageGallery.service.ImageGalleryService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")

public class ImageGalleryController {
    @Autowired
    ImageGalleryService imagegalleryService;

    @DeleteMapping(path = "/images/{id}")
     public String deleteImageGallery(@PathVariable int id) {
          return imagegalleryService.deleteImageGallery( id);
     }
}