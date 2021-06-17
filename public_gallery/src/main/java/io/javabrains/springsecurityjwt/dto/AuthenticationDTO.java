package io.javabrains.springsecurityjwt.dto;

import java.io.Serializable;

public class AuthenticationDTO implements Serializable {

    private final String token;

    public AuthenticationDTO(String jwt) {
        this.token = jwt;
    }

    public String getToken() {
        return token;
    }
}
