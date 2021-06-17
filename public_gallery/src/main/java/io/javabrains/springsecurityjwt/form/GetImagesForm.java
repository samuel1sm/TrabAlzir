package io.javabrains.springsecurityjwt.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class GetImagesForm implements Serializable {

    @NotNull
    @NotEmpty
    private String username;


    public GetImagesForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}
