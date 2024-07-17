package com.ImageGallery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;

@ExtendWith(MockitoExtension.class)
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

    @Test


    void testGetAllImageGallery() {

        // Create a list of ImageGallery objects

        List<ImageGallery> imageGalleries = new ArrayList<>();

        imageGalleries.add(new ImageGallery());

        imageGalleries.add(new ImageGallery());


        // Mock the findAll method to return the list

        when(iImageGalleryRepository.findAll()).thenReturn(imageGalleries);


        // Call the method under test

        List<ImageGallery> result = imageGalleryService.getAllImageGallery();


        // Assert the result

        assertEquals(imageGalleries, result);

    }

    public void testCreateImageGallery() {
        int newId = 123;
        ImageGallery image = new ImageGallery();
        image.setId(newId);

        when(iImageGalleryRepository.save(any(ImageGallery.class))).thenReturn(image);

        ImageGallery createdImage = imageGalleryService.createImageGallery(new ImageGallery(), newId);

        assertEquals(newId, createdImage.getId());
    }
}