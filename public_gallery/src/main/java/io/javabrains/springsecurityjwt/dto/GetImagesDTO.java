package io.javabrains.springsecurityjwt.dto;

import io.javabrains.springsecurityjwt.model.ImageInformationModel;
import io.javabrains.springsecurityjwt.util.IdKey;

public class GetImagesDTO {
    private String imageBinary;
    private String aesKey;

    public GetImagesDTO(ImageInformationModel imageInformationModel, String id) {

        for (IdKey a: imageInformationModel.getAesKeys()) {
            if(a.getId().equals(id)){
                aesKey = a.getKey();
                break;
            }
        }

        this.imageBinary = imageInformationModel.getImageBinary();

    }


    public String getImageBinary() {
        return imageBinary;
    }

    public void setImageBinary(String imageBinary) {
        this.imageBinary = imageBinary;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }



}
