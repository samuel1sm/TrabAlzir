package com.example.public_gallery.repository;

import com.example.public_gallery.model.GalleryUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GalleryUserRepository extends MongoRepository<GalleryUser, Long> {
    Optional<GalleryUser> findByEmail(String email);
    Boolean existsByEmail(String email);
}
