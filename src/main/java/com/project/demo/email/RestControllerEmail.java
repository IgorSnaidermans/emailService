package com.project.demo.email;

import com.sparkpost.exception.SparkPostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody Email email){
        try {
            boolean successful = emailService.sendEmail(email);
            if(successful){
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.badRequest().build();
            }
        } catch (SparkPostException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}