package com.example.public_gallery.controller;

import com.example.public_gallery.form.GalleryUserForm;
import com.example.public_gallery.model.GalleryUser;
import com.example.public_gallery.repository.GalleryUserRepository;
import com.example.public_gallery.security.SecurityConfigurations;
import com.example.public_gallery.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
@ResponseBody
public class AuthenticationController {



    @Autowired
    private GalleryUserRepository userRepository;

    @PostMapping("/register")
    private ResponseEntity<GalleryUser> createNewUser(@RequestBody @Valid GalleryUserForm newUser) {
        String encodedPassword = SecurityConfigurations.encodeData(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        GalleryUser user = newUser.convertToUser();
        user = userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity<?> generateAccessTokenUser(@RequestBody @Valid GalleryUserForm newUser) {


        return ResponseEntity.ok().build();


    }

}
