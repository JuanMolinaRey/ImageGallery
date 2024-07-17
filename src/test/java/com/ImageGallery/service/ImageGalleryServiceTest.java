package com.ImageGallery.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.ImageGallery.repository.IImageGalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ImageGalleryServiceTest {

    @Mock
    private IImageGalleryRepository iImageGalleryRepository;

    @InjectMocks
    private ImageGalleryService imageGalleryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteImageGallery_Success() {
        int imageId = 1;


        when(iImageGalleryRepository.existsById(imageId)).thenReturn(true);

        String result = imageGalleryService.deleteImageGallery(imageId);

        verify(iImageGalleryRepository).deleteById(imageId);
        assertEquals("You have deleted the image with ID: " + imageId, result);
    }

    @Test
    public void testDeleteImageGallery_Failure() {
        int imageId = 2;

        when(iImageGalleryRepository.existsById(imageId)).thenReturn(false);

        String result = imageGalleryService.deleteImageGallery(imageId);

        verify(iImageGalleryRepository, never()).deleteById(imageId);
        assertEquals("No image found with ID: " + imageId, result);
    }
}