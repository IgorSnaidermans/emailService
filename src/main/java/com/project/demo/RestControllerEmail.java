package com.project.demo;

import com.sparkpost.exception.SparkPostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerEmail {
    private EmailService emailService;

    @Autowired
    public RestControllerEmail(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void sendEmail(@RequestBody EmailToSend emailToSend) throws SparkPostException {
        emailService.sendEmail(emailToSend);
    }

}
