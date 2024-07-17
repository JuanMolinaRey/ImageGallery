package controller;

import com.ImageGallery.controller.ImageGalleryController;
import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ImageGalleryControllerTest {
		@Mock
		IImageGalleryRepository imageGalleryRepository;

		@InjectMocks
		ImageGalleryController imageGalleryController;

    	@BeforeEach
		public void setUp () {
			MockitoAnnotations.openMocks(this);
		}

		@Test
		void testUpdateImageGallery() {
			// Arrange
			int id = 1;
			ImageGallery imageGallery = new ImageGallery();
			imageGallery.setTitle("Updated Title");
			imageGallery.setDescription("Updated Description");
			imageGallery.setUrl("http://updated.url");

			// Act
			mock("/images/{id}", id);

			// Assert
			verify(imageGalleryController).updateImageGallery(imageGallery, id," title", "description", "url");
		}
	}
