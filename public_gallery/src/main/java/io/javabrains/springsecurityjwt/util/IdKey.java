package io.javabrains.springsecurityjwt.util;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IdKey {
    @NotNull
    @NotEmpty
    public String id;
    @NotNull
    @NotEmpty
    public String key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public IdKey(String id, String publicKey) {
        this.id = id;
        this.key = publicKey;
    }
}
