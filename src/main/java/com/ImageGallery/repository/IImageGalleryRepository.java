package com.ImageGallery.repository;

import com.ImageGallery.model.ImageGallery;
import org.springframework.data.repository.CrudRepository;

public interface IImageGalleryRepository extends CrudRepository<ImageGallery, Integer > {
}
