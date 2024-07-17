package services;
import com.ImageGallery.model.ImageGallery;
import com.ImageGallery.repository.IImageGalleryRepository;
import com.ImageGallery.service.ImageGalleryService;
import org.junit.jupiter.api.BeforeEach;
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

public class ImageGalleryServicesTests {

    @Mock
    private IImageGalleryRepository iImageGalleryRepository;

    @InjectMocks
    private ImageGalleryService imageGalleryService;

    @BeforeEach
    void setUp() {
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
        imageGalleryService.updateImageGallery(imageGallery, id, "title", "description", "url");

        // Assert
        assertEquals(id, imageGallery.getId());
        verify(iImageGalleryRepository).save(imageGallery);
    }
}
