package com.example.public_gallery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;

@Document(collection = "user")
public class GalleryUser {
    @Id
    private String id;
    @Field
    private String email;
    @Field
    private String password;

    public GalleryUser(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public GalleryUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public GalleryUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
