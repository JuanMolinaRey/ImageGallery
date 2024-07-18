package com.ImageGallery.service;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;

@ExtendWith(MockitoExtension.class)
public class ImageGalleryServiceTest {

    @Mock
    private IImageGalleryRepository iImageGalleryRepository;

    @InjectMocks
    private ImageGalleryService imageGalleryService;

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

        ImageGallery result = imageGalleryService.createImageGallery(imageToSave);

        assertEquals(id, result.getId());
        assertEquals(title, result.getTitle());
        assertEquals(description, result.getDescription());
        assertEquals(url, result.getUrl());

        verify(iImageGalleryRepository).save(any(ImageGallery.class));
    }

    @Test
    public void testDeleteImageGallery() {
        int id = 1;

        doNothing().when(iImageGalleryRepository).deleteById(id);

        imageGalleryService.deleteImageGallery(id);

        verify(iImageGalleryRepository).deleteById(id);
    }

    @Test
    public void testUpdateImageGallery() {
        int id = 1;
        String title = "Updated Title";
        String description = "Updated Description";
        String url = "http://example.com/updated_image.jpg";

        ImageGallery imageToUpdate = new ImageGallery();
        imageToUpdate.setTitle(title);
        imageToUpdate.setDescription(description);
        imageToUpdate.setUrl(url);

        when(iImageGalleryRepository.save(any(ImageGallery.class))).thenReturn(imageToUpdate);

        imageGalleryService.updateImageGallery(imageToUpdate, id);

        verify(iImageGalleryRepository).save(imageToUpdate);
        assertEquals(id, imageToUpdate.getId());
        assertEquals(title, imageToUpdate.getTitle());
        assertEquals(description, imageToUpdate.getDescription());
        assertEquals(url, imageToUpdate.getUrl());
    }

    @Test
    public void testGetAllImageGallery() {
        ArrayList<ImageGallery> images = new ArrayList<>();
        images.add(new ImageGallery(1, "Title 1", "Description 1", "http://example.com/image1.jpg"));
        images.add(new ImageGallery(2, "Title 2", "Description 2", "http://example.com/image2.jpg"));

        when(iImageGalleryRepository.findAll()).thenReturn(images);

        ArrayList<ImageGallery> result = imageGalleryService.getAllImageGallery();

        assertEquals(2, result.size());
        assertEquals("Title 1", result.get(0).getTitle());
        assertEquals("Title 2", result.get(1).getTitle());

        verify(iImageGalleryRepository).findAll();
    }
}