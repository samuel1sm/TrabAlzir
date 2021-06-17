package io.javabrains.springsecurityjwt.controller;

import io.javabrains.springsecurityjwt.dto.PublicKeysIdDTO;
import io.javabrains.springsecurityjwt.form.SendImageForm;
import io.javabrains.springsecurityjwt.model.ImageInformationModel;
import io.javabrains.springsecurityjwt.model.UserGalleryModel;
import io.javabrains.springsecurityjwt.repository.ImageInformationRepository;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageInformationRepository imageInformationRepository;

    @Transactional
    @PostMapping("/send_image")
    public ResponseEntity<?> GetImage(@RequestBody SendImageForm sendImageForm) {
        Optional<UserGalleryModel> userGalleryModel = sendImageForm.convertToUserGalleryModel(userRepository);
        if (userGalleryModel.isEmpty())
            return ResponseEntity.notFound().build();

        String userId = userGalleryModel.get().getId();
        ImageInformationModel imageInformationModel = sendImageForm.convertToImageInformation(userId);

        imageInformationRepository.save(imageInformationModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_keys")
    public ResponseEntity<?> GetAllPublicKeys() {
        List<UserGalleryModel> imageInformationModels = userRepository.findAll();
        return ResponseEntity.ok(PublicKeysIdDTO.convertList(imageInformationModels));
    }


}
