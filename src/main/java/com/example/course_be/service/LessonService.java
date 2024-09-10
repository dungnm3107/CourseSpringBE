package com.example.course_be.service;

import com.example.course_be.request.lesson.LessonRequest;
import com.example.course_be.request.lesson.LessonUpdateRequest;
import com.example.course_be.response.lesson.LessonResponse;

public interface LessonService {

    String saveLesson(LessonRequest lessonRequest);

    String updateLesson(LessonUpdateRequest lessonUpdateRequest);

    void  saveNotificationLessonForAllUsers(String message);

    LessonResponse getLessonByID(Long id);
}
