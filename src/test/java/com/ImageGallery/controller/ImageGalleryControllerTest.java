package com.ImageGallery.controller;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.service.ImageGalleryService;

@SpringBootTest
@AutoConfigureMockMvc
public class ImageGalleryControllerTest {

    @Mock
    private ImageGalleryService imagegalleryService;

    @InjectMocks
    private ImageGalleryController imageGalleryController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(imageGalleryController).build();
    }

    @Test
    public void testGetAllImageGallery() throws Exception {
        ArrayList<ImageGallery> mockImageGalleryList = new ArrayList<>();
        // Añade elementos a mockImageGalleryList si es necesario
        ImageGallery image1 = new ImageGallery(1, "Title", "algo", "http://localhost/phpmyadmin/index.php?route=/server/databases");
        ImageGallery image2 = new ImageGallery(2, "Title2", "algo", "http://localhost/phpmyadmin/index.php?route=/server/databases");

        mockImageGalleryList.add(image1);
        mockImageGalleryList.add(image2);

        when(imagegalleryService.getAllImageGallery()).thenReturn(mockImageGalleryList);

        mockMvc.perform(get("/api/v1/images/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":1,\"title\":\"Title\",\"description\":\"algo\",\"url\":\"http://localhost/phpmyadmin/index.php?route=/server/databases\"},{\"id\":2,\"title\":\"Title2\",\"description\":\"algo\",\"url\":\"http://localhost/phpmyadmin/index.php?route=/server/databases\"}]"));
    }
}