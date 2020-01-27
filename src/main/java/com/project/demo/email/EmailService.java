package com.project.demo.email;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${sparkpost.api.key}")
    private String API_KEY;
    @Value("${sparkpost.sender.name}")
    private String SENDER;
    @Value("${email.service.enabled}")
    private boolean enabled;

    public boolean sendEmail(Email email) throws SparkPostException {
        Client client = new Client(API_KEY);
        if (enabled) {
            client.sendMessage(
                    SENDER,
                    email.recipient,
                    email.emailSubject,
                    email.emailBody,
                    "<b>" + email.emailBody + "</b>");
            return true;
        }
        return false;
    }
}
