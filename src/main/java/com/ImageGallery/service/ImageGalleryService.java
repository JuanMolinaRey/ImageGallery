package com.ImageGallery.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;

@Service

public class ImageGalleryService {
    @Autowired
    private IImageGalleryRepository iImageGalleryRepository;


    public ArrayList<ImageGallery> getAllImageGallery() {
        return (ArrayList<ImageGallery>) iImageGalleryRepository.findAll();
    }

}
