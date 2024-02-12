package com.bookworm.bookworm_middleware.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ElasticEmailManager {

    @Value("${elasticemail.api-key}")
    private String apiKey;

    public void sendEmail(String from, String to, String subject, String body) {
    WebClient client = WebClient.builder()
        .baseUrl("https://api.elasticemail.com/v2/email/send")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        .build();

    client.post()
        .body(BodyInserters
            .fromFormData("apikey", apiKey)
            .with("subject", subject)
            .with("from", from)
            .with("to", to)
            .with("bodyHtml", body))
        .retrieve()
        .bodyToMono(String.class)
        .block();
    }
}