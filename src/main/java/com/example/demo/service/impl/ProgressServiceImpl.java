package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Micro;
import com.example.demo.entity.Progress;
import com.example.demo.entity.User;
import com.example.demo.enums.ProgressStatus;
import com.example.demo.repo.MicroRepository;
import com.example.demo.repo.ProgressRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.ProgressService;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MicroRepository microRepository;

    @Override
    public Progress recordProgress(Long userId, Long lessonId, Progress progress) {

        User user = userRepository.findById(userId).orElseThrow();
        Micro lesson = microRepository.findById(lessonId).orElseThrow();

        if (progress.getProgressPercent() < 0 || progress.getProgressPercent() > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100");
        }

        if (progress.getStatus() == ProgressStatus.COMPLETED &&
            progress.getProgressPercent() != 100) {
            throw new IllegalArgumentException("Completed lesson must have 100% progress");
        }

        progress.setUser(user);
        progress.setMicroLesson(lesson);

        return progressRepository.save(progress);
    }

    @Override
    public Progress getProgress(Long userId, Long lessonId) {

        User user = userRepository.findById(userId).orElseThrow();
        Micro lesson = microRepository.findById(lessonId).orElseThrow();

        return progressRepository
                .findByUserAndMicroLesson(user, lesson)
                .orElseThrow();
    }

    @Override
    public List<Progress> getUserProgress(Long userId) {

        User user = userRepository.findById(userId).orElseThrow();
        return progressRepository.findByUser(user);
    }
}
