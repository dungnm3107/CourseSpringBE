package com.example.course_be.repository;

import com.example.course_be.entity.Course;
import com.example.course_be.enums.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
     boolean existsByTitle(String courseName);

     boolean existsById(long courseId);

     List<Course> findByCourseType(CourseType courseType);
}
