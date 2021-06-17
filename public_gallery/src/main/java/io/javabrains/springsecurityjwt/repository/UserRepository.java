package io.javabrains.springsecurityjwt.repository;


import io.javabrains.springsecurityjwt.model.UserGalleryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserGalleryModel, String> {

    Optional<UserGalleryModel> findDistinctByUsername(String username);


}
