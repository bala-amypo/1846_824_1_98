package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Course;
import com.example.demo.service.Courseservice;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private Courseservice courseService;
    @PostMapping("/{instructorId}")
    public Course createCourse(
            @RequestBody Course course,
            @PathVariable Long instructorId) {
        return courseService.createCourse(course, instructorId);
    }
    @PutMapping("/{courseId}")
    public Course updateCourse(
            @PathVariable Long courseId,
            @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }
    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable Long courseId) {
        return courseService.getCourse(courseId);
    }
    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(
            @PathVariable Long instructorId) {
        return courseService.listCoursesByInstructor(instructorId);
    }
}
