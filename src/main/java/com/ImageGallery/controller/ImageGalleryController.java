package com.ImageGallery.controller;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.service.ImageGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/createImageGallery")
public class ImageGalleryController {

    @Autowired
    private ImageGalleryService imageGalleryService;

    @PostMapping("api/createImageGallery")
    public ImageGallery createImageGallery(@RequestBody ImageGallery image,
                                           @RequestParam int id,
                                           @RequestParam String title,
                                           @RequestParam String description,
                                           @RequestParam String url) {
        image.setId((long) id);
        image.setTitle(title);
        image.setDescription(description);
        image.setUrl(url);
        return imageGalleryService.createImageGallery(image);
    }
}
