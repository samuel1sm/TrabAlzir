package io.javabrains.springsecurityjwt.dto;

import io.javabrains.springsecurityjwt.model.UserGalleryModel;

import java.util.HashMap;
import java.util.List;

public class PublicKeysIdDTO {

    public static HashMap<String, String > convertList(List<UserGalleryModel> userGalleryModels){
        HashMap<String, String> result = new HashMap<>();
        userGalleryModels.forEach(a -> result.put(a.getId(), a.getPublicKey()));
        return result;
    }

}
