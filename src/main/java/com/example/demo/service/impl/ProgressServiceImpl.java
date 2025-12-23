package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ProgressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepo;
    private final UserRepository userRepo;
    private final MicroLessonRepository lessonRepo;

    public ProgressServiceImpl(ProgressRepository progressRepo,
                               UserRepository userRepo,
                               MicroLessonRepository lessonRepo) {
        this.progressRepo = progressRepo;
        this.userRepo = userRepo;
        this.lessonRepo = lessonRepo;
    }

    @Override
    public Progress recordProgress(Long userId, Long lessonId, Progress progress) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        MicroLesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));

        if (progress.getProgressPercent() < 0 || progress.getProgressPercent() > 100) {
            throw new IllegalArgumentException("Progress percent must be 0–100");
        }

        if ("COMPLETED".equals(progress.getStatus()) &&
            progress.getProgressPercent() != 100) {
            throw new IllegalArgumentException("Completed status requires 100%");
        }

        Progress existing = progressRepo
                .findByUserIdAndMicroLessonId(userId, lessonId)
                .orElse(null);

        if (existing == null) {
            progress.setUser(user);
            progress.setMicroLesson(lesson);
            return progressRepo.save(progress);
        }

        existing.setStatus(progress.getStatus());
        existing.setProgressPercent(progress.getProgressPercent());
        existing.setScore(progress.getScore());
        return progressRepo.save(existing);
    }

    @Override
    public Progress getProgress(Long userId, Long lessonId) {
        return progressRepo.findByUserIdAndMicroLessonId(userId, lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Progress not found"));
    }

    @Override
    public List<Progress> getUserProgress(Long userId) {
        return progressRepo.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
