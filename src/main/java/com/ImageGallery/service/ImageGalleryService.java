package com.ImageGallery.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;

@Service

public class ImageGalleryService {
    @Autowired
    static IImageGalleryRepository iImageGalleryRepository;

    public String deleteImageGallery(int id) {
        return "Image deleted successfully";
    }
}

    public void updateImageGallery(ImageGallery image, int id) {
        image.setId(id);
        iImageGalleryRepository.save(image);

    }

    public ArrayList<ImageGallery> getAllImageGallery() {
        return (ArrayList<ImageGallery>) iImageGalleryRepository.findAll();
    }

    @Autowired
    private IImageGalleryRepository IImageGalleryRepository;

    public static ImageGallery createImageGallery(ImageGallery image, int id, String title, String description, String url) {
        image.setId(id);
        image.setTitle(title);
        image.setDescription(description);
        image.setUrl(url);
        return iImageGalleryRepository.save(image);
    }
}
