package com.project.demo.email;

import java.util.Objects;

public class Email {
    String recipient;
    String emailSubject;
    String emailBody;

    public Email(){

    }

    private Email(Builder builder) {
        setRecipient(builder.recipient);
        setEmailSubject(builder.emailTheme);
        setEmailBody(builder.emailBody);
    }


    @Override
    public String toString() {
        return "EmailToSend{" +
                "recipient='" + recipient + '\'' +
                ", emailTheme='" + emailSubject + '\'' +
                ", emailBody='" + emailBody + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email that = (Email) o;
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
        private String recipient;
        private String emailTheme;
        private String emailBody;

        public Builder() {
        }

        public Builder recipient(String val) {
            recipient = val;
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

        public Email build() {
            return new Email(this);
        }
    }
}
