package com.project.demo;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(EmailToSend emailToSend) throws SparkPostException {
        String API_KEY = "339165f89dac945c6ad84fe63d2e8e89d505f7f8";
        Client client = new Client(API_KEY);

        client.sendMessage(
                "switter@mmm.id.lv",
                emailToSend.recipient,
                emailToSend.emailSubject,
                emailToSend.emailBody,
                "<b>" + emailToSend.emailBody + "</b>");
    }
}
