package com.pawpal.pawpal_backend.controller;

import com.pawpal.pawpal_backend.dto.MlPredictionResponse;
import com.pawpal.pawpal_backend.ml.MlClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final MlClient mlClient;

    public ImageController(MlClient mlClient) {
        this.mlClient = mlClient;
    }

    //runs when the mobile application sends an image to /analyze
    @PostMapping(value = "/analyze", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MlPredictionResponse analyze(@RequestPart("file") MultipartFile file) throws Exception {
        return mlClient.predict(                  //converts the file and sends to ML Client
            file.getBytes(),
            file.getOriginalFilename(),
            file.getContentType()
        );
    }
}