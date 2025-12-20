package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Progress;
import com.example.demo.service.ProgressService;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/record/{userId}/{lessonId}")
    public Progress recordProgress(
            @PathVariable Long userId,
            @PathVariable Long lessonId,
            @RequestBody Progress progress) {

        return progressService.recordProgress(userId, lessonId, progress);
    }

    @GetMapping("/get/{userId}/{lessonId}")
    public Progress getProgress(
            @PathVariable Long userId,
            @PathVariable Long lessonId) {

        return progressService.getProgress(userId, lessonId);
    }

    @GetMapping("/user/{userId}")
    public List<Progress> getUserProgress(@PathVariable Long userId) {
        return progressService.getUserProgress(userId);
    }
}
