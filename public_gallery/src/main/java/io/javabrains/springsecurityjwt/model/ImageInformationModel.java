package io.javabrains.springsecurityjwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Document(collection = "image_information")
public class ImageInformationModel {
    @Id
    private String id;
    private String userGalleryId;
    private String imageBinary;
    private Date creationDate;
    private HashMap<String ,String> aesKeys;

    public ImageInformationModel() {
    }

    public ImageInformationModel(String imageBinary, String userGalleryId, HashMap<String ,String> aesKeys) {
        this.imageBinary = imageBinary;
        this.userGalleryId = userGalleryId;
        this.aesKeys = aesKeys;
        this.creationDate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }



    public String getImageBinary() {
        return imageBinary;
    }

    public void setImageBinary(String imageBinary) {
        this.imageBinary = imageBinary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserGalleryId() {
        return userGalleryId;
    }

    public void setUserGalleryId(String userGalleryId) {
        this.userGalleryId = userGalleryId;
    }
}
