package com.project.demo.email;

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

    @PostMapping("/sendemail")
    public void sendEmail(@RequestBody Email email) throws SparkPostException {
        emailService.sendEmail(email);
    }

}
