package com.ImageGallery;

import com.ImageGallery.service.ImageGalleryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImageGalleryServiceTest {

    private final ImageGalleryService imageGalleryService = new ImageGalleryService();

    @Test
    public void testDeleteImageGallery_existingImage_shouldDelete() {

        int existingImageId = 123;

        String result = imageGalleryService.deleteImageGallery(existingImageId);

        assertEquals("You have deleted the image with ID: " + existingImageId, result);
    }

    @Test
    public void testDeleteImageGallery_nonExistingImage_shouldReturnErrorMessage() {

        int nonExistingImageId = 456;

        String result = imageGalleryService.deleteImageGallery(nonExistingImageId);

        assertEquals("The image with ID: " + nonExistingImageId + " does not exist.", result);
    }
}