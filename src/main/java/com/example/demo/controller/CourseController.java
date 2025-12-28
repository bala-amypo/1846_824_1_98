package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping("/{instructorId}")
    public Course create(@PathVariable Long instructorId,
                         @RequestBody Course course) {
        return service.createCourse(course, instructorId);
    }

    @PutMapping("/{courseId}")
    public Course update(@PathVariable Long courseId,
                         @RequestBody Course course) {
        return service.updateCourse(courseId, course);
    }

    @GetMapping("/{courseId}")
    public Course get(@PathVariable Long courseId) {
        return service.getCourse(courseId);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Course> list(@PathVariable Long instructorId) {
        return service.listCoursesByInstructor(instructorId);
    }
}
