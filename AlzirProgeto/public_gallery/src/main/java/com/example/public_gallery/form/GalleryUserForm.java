package com.example.public_gallery.form;



import com.example.public_gallery.model.GalleryUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GalleryUserForm {
    @NotNull @NotEmpty
    private String email;

    @NotNull @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GalleryUser convertToUser(){
        return new GalleryUser(email, password);
    }


    @Override
    public String   toString() {
        return "GalleryUserForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UsernamePasswordAuthenticationToken convertToUserAuthToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
