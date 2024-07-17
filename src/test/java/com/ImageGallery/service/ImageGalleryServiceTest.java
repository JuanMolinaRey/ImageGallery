package com.ImageGallery.service;


import com.ImageGallery.repository.IImageGalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class ImageGalleryServiceTest {

    @Mock
    private IImageGalleryRepository iImageGalleryRepository;

    @InjectMocks
    private ImageGalleryService imageGalleryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteImageGallery() {
        int id = 1;

        imageGalleryService.deleteImageGallery(id);

        verify(iImageGalleryRepository).deleteById(id);
    }
}
