package com.ImageGallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ImageGallery.repository.IImageGalleryRepository;

@Service

public class ImageGalleryService {
    @Autowired
    private IImageGalleryRepository iImageGalleryRepository;

    public String deleteImageGallery(int id) {
        if (iImageGalleryRepository.existsById(id)) {
            iImageGalleryRepository.deleteById(id);
            return "You have deleted the image with ID: " + id;
        } else {
            return "No image found with ID: " + id;
        }
    }
}


