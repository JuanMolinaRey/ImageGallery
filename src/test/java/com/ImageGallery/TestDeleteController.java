package com.ImageGallery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
public class TestDeleteController {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_Delete_Image_Gallery() throws Exception {
        int imageId = 1; // ID of the image to delete

        mockMvc.perform(MockMvcRequestBuilders.delete("/images/" + imageId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Image successfully deleted"));
    }
}