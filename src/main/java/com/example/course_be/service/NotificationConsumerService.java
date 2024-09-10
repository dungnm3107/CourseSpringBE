package com.example.course_be.service;

public interface NotificationConsumerService {

    void listenNotification(String message);

    void listenNotificationLesson(String message);
}
