package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // ✅ FIX: declare media types
    @PostMapping(
            value = "/{instructorId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course create(@PathVariable Long instructorId,
                         @RequestBody Course course) {
        return service.createCourse(course, instructorId);
    }

    // ✅ FIX: same for PUT
    @PutMapping(
            value = "/{courseId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course update(@PathVariable Long courseId,
                         @RequestBody Course course) {
        return service.updateCourse(courseId, course);
    }

    @GetMapping(
            value = "/{courseId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course get(@PathVariable Long courseId) {
        return service.getCourse(courseId);
    }

    @GetMapping(
            value = "/instructor/{instructorId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Course> list(@PathVariable Long instructorId) {
        return service.listCoursesByInstructor(instructorId);
    }
}
