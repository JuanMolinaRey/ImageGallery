package com.ImageGallery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;
import com.ImageGallery.service.ImageGalleryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class ImageGalleryServiceTest {

    @Mock
    private IImageGalleryRepository iImageGalleryRepository;

    @InjectMocks
    private ImageGalleryService imageGalleryService;

    @Test
    void testDeleteImageGallery_ImageExists() {

        int imageId = 1;
        ImageGallery imageGallery = new ImageGallery();
        imageGallery.setId(imageId);
        when(iImageGalleryRepository.findById(imageId)).thenReturn(Optional.of(imageGallery));

        String result = imageGalleryService.deleteImageGallery(imageId);

        assertEquals("You have deleted the image with ID: " + imageId, result);
        verify(iImageGalleryRepository, times(1)).deleteById(imageId);
    }

    @Test
    void testDeleteImageGallery_ImageDoesNotExist() {

        int imageId = 1;
        when(iImageGalleryRepository.findById(imageId)).thenReturn(Optional.empty());

        String result = imageGalleryService.deleteImageGallery(imageId);

        assertEquals("The image with ID: " + imageId + " does not exist.", result);
        verify(iImageGalleryRepository, never()).deleteById(imageId);
    }
}