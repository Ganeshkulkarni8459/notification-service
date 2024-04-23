package org.dnyanyog.dto.request;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Component
public class NotificationRequest {

    @NotNull(message = "Client ID is mandatory")
    @NotBlank(message = "Client ID should not be blank")
    private String clientId;

    //@NotNull(message = "Mode is mandatory")
    //@NotBlank(message = "Mode should not be blank")
    private String mode;

    //@NotNull(message = "Subject is mandatory")
   // @NotBlank(message = "Subject should not be blank")
    @Size(min = 5, max = 100, message = "Subject length must be between 5 and 100 characters")
    private String subject;

   // @NotNull(message = "Body is mandatory")
   // @NotBlank(message = "Body should not be blank")
    @Size(min = 10, max = 500, message = "Body length must be between 10 and 500 characters")
    private String body;

    private String footer;

    @NotNull(message = "From is mandatory")
    @NotBlank(message = "From should not be blank")
    @Email(message = "From should be a valid email address")
    private String from;

    @NotNull(message = "To is mandatory")
    @NotBlank(message = "To should not be blank")
    @Email(message = "To should be a valid email address")
    private String to;
    

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
