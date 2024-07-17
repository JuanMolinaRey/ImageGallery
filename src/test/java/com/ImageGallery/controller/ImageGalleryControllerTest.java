package com.ImageGallery.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.ImageGallery.service.ImageGalleryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ImageGalleryControllerTest {

    @Mock
    private ImageGalleryService imagegalleryService;

    @InjectMocks
    private ImageGalleryController imageGalleryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteImageGallery() {
        int id = 1;
        String expectedResponse = "Image gallery deleted";

        when(imagegalleryService.deleteImageGallery(id)).thenReturn(expectedResponse);

        String actualResponse = imageGalleryController.deleteImageGallery(id);

        assertEquals(expectedResponse, actualResponse);
        verify(imagegalleryService, times(1)).deleteImageGallery(id);
    }
}