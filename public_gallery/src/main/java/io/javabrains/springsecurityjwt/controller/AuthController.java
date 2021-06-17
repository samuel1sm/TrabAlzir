package io.javabrains.springsecurityjwt.controller;

import io.javabrains.springsecurityjwt.MyUserDetailsService;
import io.javabrains.springsecurityjwt.form.AuthenticationForm;
import io.javabrains.springsecurityjwt.form.RegisterUserForm;
import io.javabrains.springsecurityjwt.dto.AuthenticationDTO;
import io.javabrains.springsecurityjwt.model.UserGalleryModel;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import io.javabrains.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody AuthenticationForm authenticationRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.notFound().build();
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationDTO(jwt));
    }

    @PostMapping("/register")
    private ResponseEntity<?> subscribeClient(@Valid @RequestBody RegisterUserForm form) {

        try {
            Optional<UserGalleryModel> user = userRepository.findByUsername(form.getUsername());
            if (user.isPresent())
                return ResponseEntity.badRequest().build();

            userRepository.save(form.castToUserModel());

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok().build();
    }

}