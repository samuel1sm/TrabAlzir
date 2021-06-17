package io.javabrains.springsecurityjwt.util;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IdKey {
    @NotNull
    @NotEmpty
    public String idUser;
    @NotNull
    @NotEmpty
    public String key;

    public IdKey(String idUser, String key) {
        this.idUser = idUser;
        this.key = key;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
