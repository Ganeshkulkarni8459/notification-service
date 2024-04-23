package org.dnyanyog.controller;

import org.dnyanyog.dto.request.NotificationRequest;
import org.dnyanyog.dto.response.NotificationResponse;
import org.dnyanyog.entity.Notification;
import org.dnyanyog.enums.NotificationResponseCode;
import org.dnyanyog.repo.NotificationRepository;
import org.dnyanyog.service.NotificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

import java.time.LocalDateTime;

public class NotificationServiceUnitTestingMockito {

    @Mock
    NotificationRepository repo;

    @InjectMocks
    NotificationServiceImpl notificationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyNotificationSaveOperationReturnExpectedObject() {
        NotificationRequest request = new NotificationRequest();
        request.setClientId("CLIENT001");
        request.setMode("EMAIL");
        request.setSubject("Important Notification");
        request.setBody("Hello, this is an important notification.");
        request.setFooter("Best regards, Your App");
        request.setFrom("sender@example.com");
        request.setTo("recipient@example.com");

        Notification notificationEntity = new Notification();
        notificationEntity.setClient_id("CLIENT001")
                .setBody("Hello, this is an important notification.")
                .setMode("EMAIL")
                .setSubject("Important Notification")
                .setFooter("Best regards, Your App")
                .setFrom_email("sender@example.com")
                .setTo_email("recipient@example.com")
                .setCreated_date(LocalDateTime.now())
                .setUpdated_date(LocalDateTime.now());

        Mockito.when(repo.save(Mockito.any())).thenReturn(notificationEntity);

        NotificationResponse response = notificationService.sendNotification(request);

        Assert.assertEquals(NotificationResponseCode.SUCCESS_NOTIFICATION_SENT.getStatus(), response.getStatus());
        Assert.assertEquals(NotificationResponseCode.SUCCESS_NOTIFICATION_SENT.getCode(), response.getCode());
        Assert.assertEquals(NotificationResponseCode.SUCCESS_NOTIFICATION_SENT.getMessage(), response.getMessage());
        Assert.assertNotNull(response.getTimestamp());
    }
    
    @Test
    public void verifyNotificationOperationReturnErrorMessageOnException() {
    	
    	NotificationRequest request = new NotificationRequest();
        request.setClientId("CLIENT001");
        request.setMode("EMAIL");
        request.setSubject("Important Notification");
        request.setBody("Hello, this is an important notification.");
        request.setFrom("sender@example.com");
        request.setTo("recipient@example.com");
        
        Notification notificationEntity = new Notification();
        notificationEntity.setClient_id("CLIENT001")
                .setBody("Hello, this is an important notification.")
                .setMode("EMAIL")
                .setSubject("Important Notification")
                .setFooter("Best regards, Your App")
                .setFrom_email("sender@example.com")
                .setTo_email("recipient@example.com")
                .setCreated_date(LocalDateTime.now())
                .setUpdated_date(LocalDateTime.now());
        
        Mockito.when(repo.save(Mockito.any())).thenReturn(notificationEntity);

        NotificationResponse response = notificationService.sendNotification(request);

        Assert.assertEquals(NotificationResponseCode.ERROR_CATCH_BLOCK.getStatus(), response.getStatus());
        Assert.assertEquals(NotificationResponseCode.ERROR_CATCH_BLOCK.getCode(), response.getCode());
        Assert.assertEquals(NotificationResponseCode.ERROR_CATCH_BLOCK.getMessage(), response.getMessage());
        Assert.assertNotNull(response.getTimestamp());
        
    }
}
