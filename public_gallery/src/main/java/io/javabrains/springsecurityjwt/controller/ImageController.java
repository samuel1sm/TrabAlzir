package io.javabrains.springsecurityjwt.controller;

import io.javabrains.springsecurityjwt.dto.GetImagesDTO;
import io.javabrains.springsecurityjwt.dto.RetornoDTO;
import io.javabrains.springsecurityjwt.form.GetImagesForm;
import io.javabrains.springsecurityjwt.form.SendImageForm;
import io.javabrains.springsecurityjwt.model.ImageInformationModel;
import io.javabrains.springsecurityjwt.model.UserGalleryModel;
import io.javabrains.springsecurityjwt.repository.ImageInformationRepository;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import io.javabrains.springsecurityjwt.util.IdKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image")

public class ImageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageInformationRepository imageInformationRepository;

    @Transactional
    @PostMapping("/send_image")
    public ResponseEntity<?> sendImages(@Valid @RequestBody SendImageForm sendImageForm) {
        Optional<UserGalleryModel> userGalleryModel = sendImageForm.convertToUserGalleryModel(userRepository);
        if (userGalleryModel.isEmpty())
            return ResponseEntity.notFound().build();

        String userId = userGalleryModel.get().getId();
        ImageInformationModel imageInformationModel = sendImageForm.convertToImageInformation(userId);

        imageInformationRepository.save(imageInformationModel);
        return ResponseEntity.ok().build();
    }


    @Transactional
    @PostMapping("/get_images")
    public ResponseEntity<?> getImages(@Valid @RequestBody GetImagesForm form) {
        Optional<UserGalleryModel> userGalleryModel = userRepository.findDistinctByUsername(form.getUsername());
        if (userGalleryModel.isEmpty())
            return ResponseEntity.ok(new IdKey[]{});
        UserGalleryModel user = userGalleryModel.get();

        Date createDate = user.getCreationDate();
        Optional<List<ImageInformationModel>> image = imageInformationRepository.queryByCreationDateGreaterThanEqual(createDate);

        List<ImageInformationModel> images = image.get();
        List<GetImagesDTO> items = images.stream().map(value ->
                new GetImagesDTO(value, user.getId())).collect(Collectors.toList());


        return ResponseEntity.ok(new RetornoDTO(items));
    }

}
