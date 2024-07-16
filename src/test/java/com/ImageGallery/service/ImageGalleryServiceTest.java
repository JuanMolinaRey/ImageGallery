package com.ImageGallery.service;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class ImageGalleryServiceTest {

    @InjectMocks
    private ImageGalleryService imageGalleryService;

    @Mock
    private IImageGalleryRepository iImageGalleryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteImageGallery_WhenImageExists() {
        int id = 1;
        when(iImageGalleryRepository.findById(id)).thenReturn(Optional.of(new ImageGallery()));
        doNothing().when(iImageGalleryRepository).deleteById(id);

        String result = imageGalleryService.deleteImageGallery(id);

        assertEquals("You have deleted the image with ID: " + id, result);
    }

    @Test
    public void testDeleteImageGallery_WhenImageDoesNotExist() {
        int id = 1;
        when(iImageGalleryRepository.findById(id)).thenReturn(Optional.empty());

        String result = imageGalleryService.deleteImageGallery(id);

        assertEquals("The image with ID: " + id + " does not exist.", result);
    }

    @Test
    public void testDeleteImageGallery_WhenExceptionOccurs() {
        int id = 1;
        when(iImageGalleryRepository.findById(id)).thenThrow(new RuntimeException("Unexpected error"));

        String result = imageGalleryService.deleteImageGallery(id);

        assertEquals("An unexpected error occurred while trying to delete the image with ID: " + id, result);
    }
}
