package io.javabrains.springsecurityjwt.dto;

import io.javabrains.springsecurityjwt.model.UserGalleryModel;
import io.javabrains.springsecurityjwt.util.IdKey;

import java.util.List;
import java.util.stream.Collectors;

public class GetIdKeysDTO {
    private List<IdKey> keys;

    public GetIdKeysDTO(List<UserGalleryModel> userGalleryModels) {
        this.keys = userGalleryModels.stream()
                .map(a -> new IdKey(a.getId(), a.getPublicKey())).collect(Collectors.toList());
    }

    public List<IdKey> getKeys() {
        return keys;
    }

    public void setKeys(List<IdKey> keys) {
        this.keys = keys;
    }
}
