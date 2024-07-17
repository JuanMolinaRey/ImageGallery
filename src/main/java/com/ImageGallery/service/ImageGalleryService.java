package com.ImageGallery.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;

@Service

public class ImageGalleryService {
    @Autowired
    static IImageGalleryRepository iImageGalleryRepository;

    public void deleteImageGallery(int id) {
        iImageGalleryRepository.deleteById(id);
    }

    public void updateImageGallery(ImageGallery image, int id) {
        image.setId((long) id);
        iImageGalleryRepository.save(image);

    }

    public ArrayList<ImageGallery> getAllImageGallery() {
        return (ArrayList<ImageGallery>) iImageGalleryRepository.findAll();
    }
        @Autowired
        private IImageGalleryRepository imageGalleryRepository;

        public ImageGallery createImageGallery(ImageGallery image) {
            return imageGalleryRepository.save(image);
        }
    }
