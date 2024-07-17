package com.ImageGallery.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.service.ImageGalleryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ImageGalleryController.class)
public class ImageGalleryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImageGalleryService imageGalleryService;

    @Autowired
    private ObjectMapper objectMapper;

    private ImageGallery image;

    @BeforeEach
    public void setUp() {
        image = new ImageGallery();
    }

    @Test
    public void testDeleteImageGallery() throws Exception {
        int testId = 1;
        String expectedMessage = "You have deleted the image with ID: " + testId;

        when(imageGalleryService.deleteImageGallery(testId)).thenReturn(expectedMessage);

        mockMvc.perform(delete("/images/{id}", testId))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));

        verify(imageGalleryService, times(1)).deleteImageGallery(testId);

    }
}