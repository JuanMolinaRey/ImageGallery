package com.ImageGallery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
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

    /*@Test
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
    }*/

    @Test
    public void testCreateImageGallery() {
        int id = 123;
        String title = "Sample Title";
        String description = "Sample Description";
        String url = "http://example.com/image.jpg";

        ImageGallery imageToSave = new ImageGallery();
        imageToSave.setId(id);
        imageToSave.setTitle(title);
        imageToSave.setDescription(description);
        imageToSave.setUrl(url);

        when(iImageGalleryRepository.save(any(ImageGallery.class))).thenReturn(imageToSave);

        ImageGallery createdImage = imageGalleryService.createImageGallery(new ImageGallery());

        assertEquals(id, createdImage.getId());
        assertEquals(title, createdImage.getTitle());
        assertEquals(description, createdImage.getDescription());
        assertEquals(url, createdImage.getUrl());

        verify(iImageGalleryRepository).save(any(ImageGallery.class));
    }
}
