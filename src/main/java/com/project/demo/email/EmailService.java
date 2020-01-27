package com.project.demo.email;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${sparkpost.api.key}")
    private String API_KEY;
    @Value("${sparkpost.sender.name}")
    private String sender;
    Client client;

    @Autowired
    public EmailService(Client client) {
        this.client = client;
    }

    public void sendEmail(Email email) throws SparkPostException {
        client.sendMessage(
                sender,
                email.recipient,
                email.emailSubject,
                email.emailBody,
                "<b>" + email.emailBody + "</b>");
    }

    @Bean
    public Client initialiseClient() {
        return new Client(API_KEY);
    }
}
