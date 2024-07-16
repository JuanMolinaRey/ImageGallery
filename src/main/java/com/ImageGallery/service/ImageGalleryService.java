package com.ImageGallery.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;

@Service

public class ImageGalleryService {
    @Autowired
    IImageGalleryRepository iImageGalleryRepository;

    public String deleteImageGallery(int id) {
        try {
            if (iImageGalleryRepository.existsById(id)) {
                iImageGalleryRepository.deleteById(id);
                return "You have deleted the image with ID: " + id;
            } else {
                return "The image with ID: " + id + " does not exist.";
            }
        } catch (Exception e) {
            return "An error occurred while trying to delete the image with ID: " + id;
        }
    }

    public void updateImageGallery(ImageGallery image, int id) {
        image.setId(id);
        iImageGalleryRepository.save(image);

    }

    public ArrayList<ImageGallery> getAllImageGallery() {
        return (ArrayList<ImageGallery>) iImageGalleryRepository.findAll();
    }

}
