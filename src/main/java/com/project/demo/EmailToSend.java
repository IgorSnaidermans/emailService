package com.project.demo;

import java.util.Objects;

public class EmailToSend {
    String recipient;
    String emailSubject;
    String emailBody;

    private EmailToSend(Builder builder) {
        setRecipient(builder.recepient);
        setEmailSubject(builder.emailTheme);
        setEmailBody(builder.emailBody);
    }


    @Override
    public String toString() {
        return "EmailToSend{" +
                "recepient='" + recipient + '\'' +
                ", emailTheme='" + emailSubject + '\'' +
                ", emailBody='" + emailBody + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailToSend that = (EmailToSend) o;
        return Objects.equals(recipient, that.recipient) &&
                Objects.equals(emailSubject, that.emailSubject) &&
                Objects.equals(emailBody, that.emailBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, emailSubject, emailBody);
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public static final class Builder {
        private String recepient;
        private String emailTheme;
        private String emailBody;

        public Builder() {
        }

        public Builder recepient(String val) {
            recepient = val;
            return this;
        }

        public Builder emailTheme(String val) {
            emailTheme = val;
            return this;
        }

        public Builder emailBody(String val) {
            emailBody = val;
            return this;
        }

        public EmailToSend build() {
            return new EmailToSend(this);
        }
    }
}