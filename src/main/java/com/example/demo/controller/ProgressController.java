package com.example.demo.controller;

import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/{lessonId}")
    public Progress record(@PathVariable Long userId,
                           @PathVariable Long lessonId,
                           @RequestBody Progress progress) {
        return service.recordProgress(userId, lessonId, progress);
    }

    @GetMapping("/{userId}/{lessonId}")
    public Progress get(@PathVariable Long userId,
                        @PathVariable Long lessonId) {
        return service.getProgress(userId, lessonId);
    }

    @GetMapping("/user/{userId}")
    public List<Progress> list(@PathVariable Long userId) {
        return service.getUserProgress(userId);
    }
}
