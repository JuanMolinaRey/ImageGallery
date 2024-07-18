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

    public void updateImageGallery(ImageGallery imageGallery, int id, String title, String description, String url) {
        imageGallery.setId(id);
        imageGallery.setTitle(title);
        imageGallery.setDescription(description);
        imageGallery.setUrl(url);
        iImageGalleryRepository.save(imageGallery);
    }

    public ArrayList<ImageGallery> getAllImageGallery() {
        return (ArrayList<ImageGallery>) iImageGalleryRepository.findAll();
    }
}
