package com.example.demo.service;
import  java.util.List;
import com.example.demo.entity.Course;
public interface Courseservice{
    Course createCourse(Course course, Long instructorId);
    Course updateCourse(Long courseId, Course course);
    void deleteCourse(Long courseId);
    List<Course> listCoursesByInstructor(Long instructorId);
    Course getCourse(Long courseId);
    List<Course> getAllCourses();
}