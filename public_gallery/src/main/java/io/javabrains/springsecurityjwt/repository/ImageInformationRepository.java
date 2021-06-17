package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.model.ImageInformationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ImageInformationRepository extends MongoRepository<ImageInformationModel, String> {

    Optional<List<ImageInformationModel>> queryByCreationDateGreaterThanEqual(Date dateToCompare);
}
