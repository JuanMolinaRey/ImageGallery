package com.ImageGallery.controller;

import static org.mockito.Mockito.*;
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
        int id = 1;
        String expectedResponse = "Image gallery deleted";

        when(imageGalleryService.deleteImageGallery(id)).thenReturn(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteImageGallery")
                        .param("id", String.valueOf(id)))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));

        verify(imageGalleryService, times(1)).deleteImageGallery(id);
    }

    @Test
    public void testCreateImageGallery() throws Exception {
        int newId = 123;
        String title = "Sample Title";
        String description = "Sample Description";
        String url = "http://example.com/image.jpg";

        image.setId(newId);
        image.setTitle(title);
        image.setDescription(description);
        image.setUrl(url);

        when(imageGalleryService.createImageGallery(any(ImageGallery.class), anyInt(), anyString(), anyString(), anyString()))
                .thenReturn(image);

        mockMvc.perform(MockMvcRequestBuilders.post("/createImageGallery")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(image))
                        .param("id", String.valueOf(newId))
                        .param("title", title)
                        .param("description", description)
                        .param("url", url))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(image)));

        verify(imageGalleryService, times(1)).createImageGallery(any(ImageGallery.class), eq(newId), eq(title), eq(description), eq(url));
    }
}