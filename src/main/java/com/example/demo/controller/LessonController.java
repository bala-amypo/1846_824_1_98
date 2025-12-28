package com.example.demo.controller;

import com.example.demo.model.MicroLesson;
import com.example.demo.service.LessonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    // 🔹 ADD LESSON TO COURSE (FIX 415)
    @PostMapping(
        value = "/course/{courseId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MicroLesson add(
            @PathVariable Long courseId,
            @RequestBody MicroLesson lesson
    ) {
        return service.addLesson(courseId, lesson);
    }

    // 🔹 UPDATE LESSON (FIX 415)
    @PutMapping(
        value = "/{lessonId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MicroLesson update(
            @PathVariable Long lessonId,
            @RequestBody MicroLesson lesson
    ) {
        return service.updateLesson(lessonId, lesson);
    }

    // 🔹 GET LESSON BY ID
    @GetMapping("/{lessonId}")
    public MicroLesson get(@PathVariable Long lessonId) {
        return service.getLesson(lessonId);
    }

    // 🔹 SEARCH LESSONS
    @GetMapping("/search")
    public List<MicroLesson> search(
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String contentType
    ) {
        return service.findLessonsByFilters(tags, difficulty, contentType);
    }
}
