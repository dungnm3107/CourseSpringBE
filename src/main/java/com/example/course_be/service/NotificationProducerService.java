package com.example.course_be.service;

public interface NotificationProducerService {

    void sendNotification(String message);

    void sendNotificationLesson(String message);
}
