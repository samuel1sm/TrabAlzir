package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.model.ImageInformationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageInformationRepository extends MongoRepository<ImageInformationModel, String> {

}
