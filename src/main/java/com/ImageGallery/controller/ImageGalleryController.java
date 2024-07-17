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

     @PutMapping (path = "/images/{id}")
     public void updateImageGallery(@RequestBody ImageGallery imageGallery, @PathVariable int id, @RequestParam String title, @RequestParam String url, @RequestParam String description){
          imagegalleryService.updateImageGallery(imageGallery, id, title, description, url);

     }

}