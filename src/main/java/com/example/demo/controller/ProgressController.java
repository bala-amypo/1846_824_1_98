package com.example.demo.controller;

import com.example.demo.dto.ProgressRequest;
import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/{userId}/{lessonId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Progress save(
            @PathVariable Long userId,
            @PathVariable Long lessonId,
            @RequestBody ProgressRequest request) {

        Progress progress = new Progress();
        progress.setStatus(request.getStatus());
        progress.setProgressPercent(request.getProgressPercent());
        progress.setScore(request.getScore());

        return service.recordProgress(userId, lessonId, progress);
    }

    @GetMapping(
            value = "/{userId}/{lessonId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Progress get(
            @PathVariable Long userId,
            @PathVariable Long lessonId) {

        return service.getProgress(userId, lessonId);
    }

    @GetMapping(
            value = "/user/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Progress> list(@PathVariable Long userId) {
        return service.getUserProgress(userId);
    }
}
