package com.ImageGallery.controller;

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ImageGalleryController.class)

public class ImageGalleryControlerTest {

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
            image.setId(1); // Configuración inicial del objeto
        }

        @Test
        public void testCreateImageGallery() throws Exception {
            int newId = 123;
            image.setId(newId);

            when(imageGalleryService.createImageGallery(any(ImageGallery.class), any(Integer.class)))
                    .thenReturn(image);

            mockMvc.perform(MockMvcRequestBuilders.post("/createImageGallery")
                            .contentType("application/json")
                            .content(objectMapper.writeValueAsString(image))
                            .param("id", String.valueOf(newId)))
                    .andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(image)));
        }
    }

