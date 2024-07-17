package com.ImageGallery.controller;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.service.ImageGalleryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class ImageGalleryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ImageGalleryService imagegalleryService;

    @InjectMocks
    private ImageGalleryController imageGalleryController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(imageGalleryController).build();
    }

    @Test
    public void testDeleteImageGallery() throws Exception {
        when(imagegalleryService.deleteImageGallery(anyInt())).thenReturn("Deleted");

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/images/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUpdateImageGallery() throws Exception {
        doNothing().when(imagegalleryService).updateImageGallery(any(ImageGallery.class), anyInt());

        ImageGallery imageGallery = new ImageGallery();
        imageGallery.setId(1);
        imageGallery.setTitle("Test Title");
        imageGallery.setDescription("Test Description");
        imageGallery.setUrl("http://test.url");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/images/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(imageGallery)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGetAllImageGallery() throws Exception {
        ArrayList<ImageGallery> list = new ArrayList<>();
        list.add(new ImageGallery());

        when(imagegalleryService.getAllImageGallery()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/images/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(list)))
                .andDo(MockMvcResultHandlers.print());
    }

   
}
