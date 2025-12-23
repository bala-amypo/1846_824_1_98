package com.example.demo.controller;

import com.example.demo.model.MicroLesson;
import com.example.demo.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @PostMapping("/course/{courseId}")
    public MicroLesson add(@PathVariable Long courseId,
                           @RequestBody MicroLesson lesson) {
        return service.addLesson(courseId, lesson);
    }

    @PutMapping("/{lessonId}")
    public MicroLesson update(@PathVariable Long lessonId,
                              @RequestBody MicroLesson lesson) {
        return service.updateLesson(lessonId, lesson);
    }

    @GetMapping("/{lessonId}")
    public MicroLesson get(@PathVariable Long lessonId) {
        return service.getLesson(lessonId);
    }

    // ✅ FIXED METHOD NAME
    @GetMapping("/search")
    public List<MicroLesson> search(@RequestParam(required = false) String tags,
                                    @RequestParam(required = false) String difficulty,
                                    @RequestParam(required = false) String contentType) {

        return service.findLessonsByFilters(tags, difficulty, contentType);
    }
}
