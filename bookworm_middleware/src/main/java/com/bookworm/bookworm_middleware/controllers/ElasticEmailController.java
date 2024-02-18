package com.bookworm.bookworm_middleware.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.services.ElasticEmailManager;
import com.bookworm.bookworm_middleware.entities.ElasticEmail;

@RestController
@CrossOrigin("*")
public class ElasticEmailController {

    private ElasticEmailManager elasticEmailManager;

    @Autowired
    public ElasticEmailController(ElasticEmailManager elasticEmailManager) {
        this.elasticEmailManager = elasticEmailManager;
    }

    @PostMapping("/api/contact")
    public void sendEmail(@RequestBody ElasticEmail elasticEmail) {
        String body = "Message from: " + elasticEmail.getName() + "\n\n" + elasticEmail.getMessage();
        elasticEmailManager.sendEmail(elasticEmail.getEmail(), "infinityrisky999@gmail.com", elasticEmail.getSubject(),
                body);
    }
}