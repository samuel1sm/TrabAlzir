package io.javabrains.springsecurityjwt.util;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IdKey {
    @NotNull
    @NotEmpty
    public String id;
    @NotNull
    @NotEmpty
    public String publicKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public IdKey(String id, String publicKey) {
        this.id = id;
        this.publicKey = publicKey;
    }
}
