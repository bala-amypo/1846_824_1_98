package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.MicroLesson;
import com.example.demo.service.LessonService;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/add/{courseId}")
    public MicroLesson addLesson(
            @PathVariable Long courseId,
            @RequestBody MicroLesson lesson) {

        return lessonService.addLesson(courseId, lesson);
    }

    @PutMapping("/update/{lessonId}")
    public MicroLesson updateLesson(
            @PathVariable Long lessonId,
            @RequestBody MicroLesson lesson) {

        return lessonService.updateLesson(lessonId, lesson);
    }

    @GetMapping("/get/{lessonId}")
    public MicroLesson getLesson(@PathVariable Long lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @GetMapping("/filter")
    public List<MicroLesson> findLessons(
            @RequestParam String tags,
            @RequestParam String difficulty,
            @RequestParam String contentType) {

        return lessonService.findLessonsByFilters(
                tags,
                difficulty,
                contentType
        );
    }
}
