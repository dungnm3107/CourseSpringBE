package com.example.course_be.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface EmailConsumerService {

     void listenEmailNotifications(String message) throws JsonProcessingException;

}
