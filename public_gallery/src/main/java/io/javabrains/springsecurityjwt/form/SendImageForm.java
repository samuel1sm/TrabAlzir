package io.javabrains.springsecurityjwt.form;

import io.javabrains.springsecurityjwt.model.ImageInformationModel;
import io.javabrains.springsecurityjwt.model.UserGalleryModel;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import io.javabrains.springsecurityjwt.util.IdKey;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class SendImageForm {

    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String imageBinary;

    @NotEmpty
    @NotNull
    private List<IdKey> aesKey;


    public List<IdKey> getAesKey() {
        return aesKey;
    }

    public void setAesKey(List<IdKey> aesKey) {
        this.aesKey = aesKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageBinary() {
        return imageBinary;
    }

    public void setImageBinary(String imageBinary) {
        this.imageBinary = imageBinary;
    }

    public ImageInformationModel convertToImageInformation(String userId) {
        return new ImageInformationModel(imageBinary, userId, aesKey);
    }

    public Optional<UserGalleryModel> convertToUserGalleryModel(UserRepository userRepository) {
        return userRepository.findDistinctByUsername(username);
    }
}
