package com.ImageGallery.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ImageGallery.service.ImageGalleryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ImageGalleryController.class)
public class ImageGalleryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ImageGalleryService imageGalleryService;

    @InjectMocks
    private ImageGalleryController imageGalleryController;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders
                .standaloneSetup(imageGalleryController)
                .build();
    }

    @Test
    public void testDeleteImageGallery_Success() throws Exception {
        int imageId = 1;
        String expectedResponse = "You have deleted the image with ID: " + imageId;

        when(imageGalleryService.deleteImageGallery(imageId)).thenReturn(expectedResponse);

        mockMvc.perform(delete("/api/images/{id}", imageId))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    public void testDeleteImageGallery_Failure() throws Exception {
        int imageId = 2;
        String expectedResponse = "No image found with ID: " + imageId;

        when(imageGalleryService.deleteImageGallery(imageId)).thenReturn(expectedResponse);

        mockMvc.perform(delete("/api/images/{id}", imageId))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}