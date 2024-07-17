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
