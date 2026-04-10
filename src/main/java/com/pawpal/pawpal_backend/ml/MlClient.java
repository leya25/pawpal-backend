package com.pawpal.pawpal_backend.ml;

import com.pawpal.pawpal_backend.dto.MlPredictionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service   //communicates with the external machine learning service
public class MlClient {

    private final WebClient webClient;

    public MlClient(@Value("${ml.service.url}") String baseUrl) {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public MlPredictionResponse predict(byte[] bytes, String filename, String contentType) {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();

        //determine the image file type
        MediaType mt = MediaType.IMAGE_JPEG;
        if (contentType != null) {
            try { mt = MediaType.parseMediaType(contentType); } catch (Exception ignored) {}
        }

        //attach image file to the request
        builder.part("file", new ByteArrayResource(bytes) {
            @Override public String getFilename() {
                return (filename != null && !filename.isBlank()) ? filename : "image.jpg";
            }
        }).contentType(mt);

        //send request to ML service and return its response
        return webClient.post()
                .uri("/predict")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()
                .bodyToMono(MlPredictionResponse.class)
                .block();
    }
}

