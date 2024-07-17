package com.ImageGallery.controller;

import com.ImageGallery.service.ImageGalleryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ImageGalleryController.class)
public class ImageGalleryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImageGalleryService imageGalleryService;

    @Test
    public void testDeleteImageGallery() throws Exception {
        int id = 1;

        doNothing().when(imageGalleryService).deleteImageGallery(id);

        mockMvc.perform(delete("/api/v1/images/{id}", id))
                .andExpect(status().isOk());

        verify(imageGalleryService).deleteImageGallery(id);
    }
}