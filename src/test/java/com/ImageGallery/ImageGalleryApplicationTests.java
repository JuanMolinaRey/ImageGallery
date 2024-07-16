package com.ImageGallery;

import com.ImageGallery.controller.ImageGalleryController;
import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

class ImageGalleryApplicationTests {
		@Mock
		IImageGalleryRepository imageGalleryRepository;

		@InjectMocks
		ImageGalleryController imageGalleryController;

    	@Before
	    public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
	    }

		@Test
		public void createImageTest () {
			ImageGallery image = new ImageGallery();
			image.setTitle("Create Image Test");
			int id = 1;

			when(imageGalleryRepository.save(any(ImageGallery.class))).thenReturn(image);

			ImageGallery result = imageGalleryController.createImageGallery(image, id);

			assertEquals(id, result.getId());

			assertEquals("Create Image Test", result.getTitle());

			verify(imageGalleryRepository, times(1)).save(image);
		}
	}
