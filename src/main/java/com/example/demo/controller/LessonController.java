package com.example.demo.controller;

import com.example.demo.dto.LessonRequest;
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

    // ✅ FIXED: DTO for input, Entity for output
    @PostMapping(
            value = "/course/{courseId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MicroLesson add(
            @PathVariable Long courseId,
            @RequestBody LessonRequest request) {

        MicroLesson lesson = new MicroLesson();
        lesson.setTitle(request.getTitle());
        lesson.setDurationMinutes(request.getDurationMinutes());
        lesson.setContentType(request.getContentType());
        lesson.setDifficulty(request.getDifficulty());
        lesson.setTags(request.getTags());
        lesson.setPublishDate(request.getPublishDate());

        return service.addLesson(courseId, lesson);
    }

    // ✅ PUT also fixed
    @PutMapping(
            value = "/{lessonId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MicroLesson update(
            @PathVariable Long lessonId,
            @RequestBody LessonRequest request) {

        MicroLesson lesson = new MicroLesson();
        lesson.setTitle(request.getTitle());
        lesson.setDurationMinutes(request.getDurationMinutes());
        lesson.setContentType(request.getContentType());
        lesson.setDifficulty(request.getDifficulty());
        lesson.setTags(request.getTags());
        lesson.setPublishDate(request.getPublishDate());

        return service.updateLesson(lessonId, lesson);
    }

    @GetMapping(
            value = "/{lessonId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MicroLesson get(@PathVariable Long lessonId) {
        return service.getLesson(lessonId);
    }

    @GetMapping(
            value = "/search",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<MicroLesson> search(
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String contentType) {

        return service.findLessonsByFilters(tags, difficulty, contentType);
    }
}
