package com.example.course_be.service.impl;

import com.example.course_be.service.EmailService;
import com.example.course_be.service.EmailConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumerServiceImpl implements EmailConsumerService {

    private static final Logger log = LoggerFactory.getLogger(EmailConsumerServiceImpl.class);

    @Autowired
    private EmailService emailService;

    @Override
//    @KafkaListener(topics = "email-notifications-topic" , groupId = "notification-group")
    public void listenEmailNotifications(String message) throws JsonProcessingException {
        emailService.sendEmailToAllUsers(message);
        log.info("Email sent to all users");
    }

}
