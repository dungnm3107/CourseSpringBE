package com.example.course_be.service;

import com.example.course_be.request.course.CourseRequest;
import com.example.course_be.request.course.CourseUpdateRequest;
import com.example.course_be.response.course.CourseResponse;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CourseService {

    String saveCourse(CourseRequest courseRequest);

    CourseResponse getCourseById(Long courseId);

    List<CourseResponse> getAllCourses();

    String deleteCourseById(Long courseId);



    String updateCourse(CourseUpdateRequest courseUpdateRequest);

    String changeStatusCourse(Long courseId);

    void saveNotificationForAllUsers(String message);

    List<CourseResponse> getAllPaidCourses();

    List<CourseResponse> getAllFreeCourses();

}
