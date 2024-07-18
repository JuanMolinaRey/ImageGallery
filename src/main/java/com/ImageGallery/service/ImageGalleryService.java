package com.ImageGallery.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;

@Service
public class ImageGalleryService {

    private final IImageGalleryRepository iImageGalleryRepository;

    @Autowired
    public ImageGalleryService(IImageGalleryRepository iImageGalleryRepository) {
        this.iImageGalleryRepository = iImageGalleryRepository;
    }

    public ImageGallery createImageGallery(ImageGallery imageGallery) {
        return iImageGalleryRepository.save(imageGallery);
    }

    public void deleteImageGallery(int id) {
        iImageGalleryRepository.deleteById(id);
    }

    public void updateImageGallery(ImageGallery image, int id) {
        image.setId(id);
        iImageGalleryRepository.save(image);
    }

    public ArrayList<ImageGallery> getAllImageGallery() {
        return (ArrayList<ImageGallery>) iImageGalleryRepository.findAll();
    }
}