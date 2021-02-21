package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.json.DeepAiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimilarityLevelController {
    @GetMapping("/test")
    public int process(@RequestParam String url1, @RequestParam String url2) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("api-key", "7983f7ad-3d48-4217-8a68-2934647d4da6");

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("image1", url1);
        body.add("image2", url2);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String serverUrl = "https://api.deepai.org/api/image-similarity";

        RestTemplate restTemplate = new RestTemplate();
        DeepAiResponse deepAiResponse = restTemplate.postForObject(serverUrl, requestEntity, DeepAiResponse.class);
        return deepAiResponse.getOutput().getDistance();
    }
}
