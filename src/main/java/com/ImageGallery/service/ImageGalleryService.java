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

    public void updateImageGallery(ImageGallery imageGallery, int id, String title, String description, String url) {
        imageGallery.setId(id);
        imageGallery.setTitle(title);
        imageGallery.setDescription(description);
        imageGallery.setUrl(url);
        iImageGalleryRepository.save(imageGallery);
    }

}
