package io.javabrains.springsecurityjwt.form;

import io.javabrains.springsecurityjwt.model.UserGalleryModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class RegisterUserForm implements Serializable {

    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String publicKey;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public UserGalleryModel castToUserModel() {
        return new UserGalleryModel(username, password, publicKey);
    }

    @Override
    public String toString() {
        return "RegisterUserForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", publicKey='" + publicKey + '\'' +
                '}';
    }
}
