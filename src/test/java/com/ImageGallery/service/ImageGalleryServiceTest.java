package com.ImageGallery.service;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

class ImageGalleryServiceTest {

    @Mock
    private IImageGalleryRepository imageGalleryRepository;

    @InjectMocks
    private ImageGalleryService imageGalleryService;

    private ImageGallery imageGallery;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        imageGallery = new ImageGallery();
        imageGallery.setId((long) 11L);
        imageGallery.setTitle("Las chicas superpoderosas");
        imageGallery.setDescription("Bombon, burbuja y bellota");
        imageGallery.setUrl("https://cartoonnetwork.fandom.com/es/wiki/Las_Chicas_Superpoderosas");
    }

    @Test
    void createImageGallery() {
        when(imageGalleryRepository.save(any(ImageGallery.class))).thenReturn(imageGallery);

        ImageGallery createdImageGallery = imageGalleryService.createImageGallery(imageGallery);

        verify(imageGalleryRepository).save(imageGallery);
    }
}
